"""
Todo: rename this module
"""
from lxml import etree

import logging

class SchemaMapper():
    '''
    SchemaMapper class
    '''

    def __init__(self, tree):
        self.tree = tree

    def map(self):
        '''
        Returns the XSD mapped from XML-etree input to a dictionary representation
        '''
        root = self.tree.getroot()
        qualified = True if root.attrib['elementFormDefault'] == 'qualified' else False
        tns = root.attrib['targetNamespace'] if 'targetNamespace' in root.attrib else ''

        schema = {
            'tns': tns,
            'qualified': qualified,
            'nsmap': root.nsmap,
            'attributes': [],
            'types': [],
            'elements': []
        }

        for schema_import in [_ for _ in root.iterchildren(tag=self.qualify('import', root))]:
            pass
            # is not automatically resolved in lxml, could be implemented in a future version
        for attribute in [_ for _ in root.iterchildren(tag=self.qualify('attribute', root))]:
            schema['attributes'].append(self.map_attribute(attribute))
        for simple_type in [_ for _ in root.iterchildren(tag=self.qualify('simpleType', root))]:
            schema['types'].append(self.map_simple_type(simple_type))
        for complex_type in [_ for _ in root.iterchildren(tag=self.qualify('complexType', root))]:
            schema['types'].append(self.map_complex_type(complex_type))
        for element in [_ for _ in root.iterchildren(tag=self.qualify('element', root))]:
            schema['elements'].append(self.map_element(element))

        return schema

    def map_import(self, schema_import):
        '''
        Note: lxml resolves schema imports only when a validator is created through etree.XMLSchema()
        '''
        raise NotImplementedError('Importing of referenced schemas is not implemented yet!')

    def map_type(self, type, nsmap):
        '''
        Returns the mapped type declaration

        Args:
            type (str): Type declaration, f.e. xsd:long where *xsd* is the namespace prefix and *long* the type name
        '''
        if ':' in type:
            prefix, name = type.split(':')
        else:
            name = type
            prefix = None
        ns = ''
        if prefix in nsmap:
            ns = nsmap[prefix]
        else:
            logging.debug('Could not find namespace to prefix "{}" of attribute "{}"'.format(prefix, name))
        return {
            'prefix': prefix,
            'name': name,
            'ns': ns
        }

    def map_attribute(self, attribute):
        '''
        Returns the mapped attribute

        see http://www.w3.org/TR/xmlschema-1/#cAttribute_Declarations

        Args:
            attribute (lxml.etree._Element):
                Element object that contains a attribute definition
        '''
        content = {}
        if 'name' in attribute.attrib:
            content['name'] = attribute.attrib['name']
            if 'fixed' in attribute.attrib:
                content['fixed'] = attribute.attrib['fixed']
            if 'default' in attribute.attrib:
                content['default'] = attribute.attrib['default']
            if 'use' in attribute.attrib:
                # optional, required or prohibited
                content['use'] = attribute.attrib['use']
            if 'type' in attribute.attrib:
                content['type'] = self.map_type(attribute.attrib['type'], attribute.nsmap)
            elif len(attribute):
                if attribute[0].tag == self.qualify('simpleType', attribute[0]):
                    content['type'] = self.map_simple_type(attribute[0])
                else:
                    logging.debug('Bad attribute type {}'.format(attribute[0].tag))
            else:
                logging.debug('Wether type-declration nor type-definition in attribute {}'.format(name))
        elif 'ref' in attribute.attrib:
            # if qualified
            prefix, reference = attribute.attrib['ref'].split(':')
            if prefix in attribute.nsmap.keys():
                content['ref'] = {
                    'reference': reference,
                    'prefix': prefix,
                    'ns': attribute.nsmap[prefix]
                }
            else:
                logging.debug('Unqualified schema?')
        else:
            logging.debug('Wether "reference" nor a "explicit declaration"!')
        return content

    def map_simple_type(self, simple):
        '''
        Returns the mapped simpleType

        see http://www.w3.org/TR/2004/REC-xmlschema-2-20041028/datatypes.html#element-simpleType

        Args:
            simple (lxml.etree._Element): Element object that stores the simpleType definition
        '''
        content = {}
        parent = simple.getparent()
        if 'name' in simple.attrib.keys():
            content['name'] = simple.attrib['name']
        elif parent.tag is self.qualify('schema', parent):
            logging.warn('Anonymous simpleType as direct child of "schema" element!')
            return {}
        if len(simple):
            for child in simple:
                if child.tag == self.qualify('restriction', child):
                    content['content'] = self.simple_type_restriction(child)
                elif child.tag == self.qualify('list', child):
                    content['list'] = self.simple_type_list(child)
                elif child.tag == self.qualify('union', child):
                    content['union'] = self.simple_type_union()
                else:
                    logging.debug('Unexpected element "{}" in "{}"'.format(child.tag, name))
        else:
            logging.debug('SimpleType "{}" is empty'.format(name))
        return content

    def simple_type_restriction(self, restriction):
        '''
        Returns mapped simpleType restriction definiton

        see http://www.w3.org/TR/2004/REC-xmlschema-2-20041028/datatypes.html#element-restriction
        or http://msdn.microsoft.com/en-us/library/ms256219(v=vs.110).aspx

        Args:
            restriction (lxml.etree._Element): Element containing the simpleType restriction
        '''
        content = {
            'base': self.map_type(restriction.attrib['base'], restriction.nsmap)
        }
        if len(restriction):
            for child in restriction:
                tag = self.unqualify(child.tag, child)
                if tag == 'enumeration':
                    if not 'enumeration' in content:
                        content['enumeration'] = []
                    content['enumeration'].append(child.attrib['value'])
                    content['restrictions'] = {}
                    for attribute in child.attrib:
                        lower = attribute.lower()
                        if 'max' in lower or 'min' in lower:
                            if 'exclusive' in lower:
                                if lower == 'maxExclusive':
                                    content['restrictions']['exclusive'] = { 'max': child.attrib['maxExclusive'] }
                                else:
                                    content['restrictions']['exclusive'] = { 'min': child.attrib['minExclusive']}
                            elif 'inclusive' in lower:
                                if lower == 'maxInclusive':
                                    content['restrictions']['inclusive'] = { 'max': child.attrib['maxInclusive'] }
                                else:
                                    content['restrictions']['inclusive'] = { 'min': child.attrib['minInclusive']}
                            elif 'length' in lower:
                                if lower == 'maxLength':
                                    content['restrictions']['length'] = { 'max': child.attrib['maxLength'] }
                                else:
                                    content['restrictions']['length'] = { 'min': child.attrib['minLength']}
                            else:
                                logging.debug('Unsupported attribute "{}" in SimpleType restriction'.format(attribute))
                else:
                    logging.debug('Unsupported tag "{}" in SimpleType'.format(child.tag))
        return content

    def simple_type_list(self, listElement):
        '''
        Returns mapped simpleType list

        Args:
            listElement (lxml.etree._Element): Element that contains the simpleType list definition
        '''
        content = {}
        if 'itemType' in listElement.attrib:
            content['type'] = listElement.attrib['itemType']
        else:
            logging.debug('List without itemType attribute!')
        return content

    def simple_type_union(self):
        raise NotImplementedError('SimpleType unions are not implemented yet!')

    def map_complex_type(self, complex):
        '''
        Returns the mapped complexType

        see http://www.w3.org/TR/xmlschema-1/#Complex_Type_Definitions

        Args:
            complex (lxml.etree._Element): Element that contains a complexType definition
        '''
        content = {
            'anonymous': False
        }
        if 'name' in complex.attrib:
            content['name'] = complex.attrib['name']
        else:
            content['anonymous'] = True
        if 'abstract' in complex.attrib:
            content['abstract'] = True if complex.attrib['abstract'].lower() == "true" else False
        if 'mixed' in complex.attrib:
            content['mixed'] = True if complex.attrib['mixed'].lower() == "true" else False
        if 'final' in complex.attrib:
            content['final'] = complex.attrib['final'].split()
        if 'base' in complex.attrib:
            content['base'] = complex.attrib['base']
        if len(complex):
            for child in complex:
                # attribute, complexContent, sequence, simpleContent, all
                unqualified = self.unqualify(child.tag, child)
                if 'attribute' == unqualified:
                    if not 'attributes' in content:
                        content['attributes'] = []
                    content['attributes'].append(self.map_attribute(child))
                elif 'complexContent' == unqualified:
                    content['content'] = self.map_complex_content(child)
                elif 'sequence' == unqualified:
                    content['ordering'] = self.map_sequence(child)
                elif 'simpleContent' == unqualified:
                    content['content'] = self.map_simple_content(child)
                elif 'all' == unqualified:
                    # elements can occur in any order
                    content['all'] = self.map_sequence(child)
                else:
                    logging.debug('Unexpected element "{}"'.format(unqualified))
        return content

    def map_complex_content(self, complex):
        '''
        Returns the mapped complexContent

        Args:
            complex (lxml.etree._Element): Element that contains the complexType definition
        '''
        content = {}
        if complex[0].tag == self.qualify('extension', complex[0]):
            content['extends'] = {
                'base': self.map_type(complex[0].attrib['base'], complex[0].nsmap)
            }
        elif complex[0].tag == self.qualify('restriction', complex[0]):
            content['restricts'] = {
                'base': self.map_type(complex[0].attrib['base'], complex[0].nsmap)
            }
        else:
            logging.debug('Bad complexContent definition with direct child {}'.format(simple[0].tag))
        for child in complex[0]:
            if child.tag == self.qualify('sequence', child):
                content['ordering'] = self.map_sequence(child)
            elif child.tag == self.qualify('attribute', child):
                if not 'attributes' in content:
                    content['attributes'] = []
                content['attributes'].append(self.map_attribute(child))
        return content

    def map_sequence(self, element):
        '''
        Returns the mapped sequence definition

        Args:
            element (lxml.etree._Element):
                Element that contains a complexType sequence definition
        '''
        ordering = {}
        # elements must appear in that order
        for child in element:
            if child.tag == self.qualify('element', child):
                if 'sequence' not in ordering:
                    ordering['sequence'] = []
                ordering['sequence'].append(self.map_element(child))
            elif child.tag == self.qualify('choice', child):
                # http://msdn.microsoft.com/de-de/library/ms256109(v=vs.110).aspx
                # only of of the contained elements should be present!
                for choiceElement in child:
                    if 'choice' not in ordering:
                        ordering['choice'] = []
                    ordering['choice'].append(self.map_element(choiceElement))
            elif child.tag == self.qualify('any', child):
                # http://msdn.microsoft.com/de-de/library/ms256043(v=vs.110).aspx
                # elements can be part of arbitrary namespaces
                ordering['any'] = {}
                for attribute in child.attrib:
                    if 'occurs' in attribute.lower():
                        ordering['occurance'] = {
                            'min': 1,
                            'max': 1
                        }
                        if attribute == 'minOccurs':
                            ordering['occurance']['min'] = child.attrib[attribute]
                        elif attribute == 'maxOccurs':
                            ordering['occurance']['max'] = child.attrib[attribute]
                    elif attribute == 'namespace':
                        # http://msdn.microsoft.com/de-de/library/ms256043(v=vs.110).aspx
                        ordering['any']['namespace'] = child.attrib[attribute]
            else:
                logging.debug('Unimplemented tag "{}"'.format(subchild.tag))
        return ordering

    def map_simple_content(self, simple):
        '''
        Returns the mapped simpleType

        see http://msdn.microsoft.com/de-de/library/ms256106(v=vs.110).aspx

        Args:
            simple (lxml.etree._Element): Element containing the simpleContent definition
        '''
        content = {}
        unqualified = self.unqualify(simple[0].tag, simple[0])
        if unqualified == 'extension':
            content['extends'] = {
                'base': self.map_type(simple[0].attrib['base'], simple[0].nsmap)
            }
        elif unqualified == 'restriction':
            content['restricts'] = {
                'base': self.map_type(simple[0].attrib['base'], simple[0].nsmap)
            }
        else:
            logging.debug('Bad simpleContent definition with direct child {}'.format(simple[0].tag))
        if len(simple[0]):
            for child in simple[0]:
                unqualified = self.unqualify(child.tag, child)
                if unqualified == 'attribute':
                    if 'attributes' not in content:
                        content['attributes'] = []
                    content['attributes'].append(self.map_attribute(child))
                else:
                    print(child.tag, child.attrib)
        else:
            logging.debug('Empty simpleContent!')
        return content

    def map_element(self, element):
        '''
        Returns the mapped element

        Args:
            element (lxml.etree._Element): Element containing a XML Element definition
        '''
        content = {
            'occurance': {
                'min': 1,
                'max': 1
            }
        }
        for key in element.attrib:
            if key == 'name':
                content['name'] = element.attrib[key]
            elif key == 'type':
                content['type'] = self.map_type(element.attrib[key], element.nsmap)
            elif 'occurs' in key.lower():
                if key == 'minOccurs':
                    content['occurance']['min'] = element.attrib[key]
                elif key == 'maxOccurs':
                    content['occurance']['max'] = element.attrib[key]
            elif key == 'nillable':
                content['nillable'] = True if element.attrib[key] == 'true' else False
            elif key == 'ref':
                prefix, reference = element.attrib['ref'].split(':')
                if prefix in element.nsmap.keys():
                    content['ref'] = {
                        'reference': reference,
                        'prefix': prefix,
                        'ns': element.nsmap[prefix]
                    }
                else:
                    logging.debug('Unqualified schema?')
            else:
                logging.debug('Unexpected attribute "{}"'.format(key))
        if len(element):
            for child in element:
                if child.tag == self.qualify('complexType', child):
                    content['type'] = self.map_complex_type(child)
                elif child.tag == self.qualify('simpleType', child):
                    content['type'] = self.map_simple_type(child)
                else:
                    logging.debug('Unexpected child "{}" of element "{}" with name "{}".'.format(child.tag, element.tag, element.attrib['name']))
        return content

    def qualify(self, name, node):
        '''
        Returns the qualified name of a node, f.e. "{http://www.w3.org/2001/XMLSchema}attribute"
        '''
        if node.prefix in node.nsmap:
            return '{{{}}}{}'.format(node.nsmap[node.prefix], name)
        else:
            logging.warn('Could not find a namespace to node {}:{}'.format(node.prefix, node.tag))
            return ''

    def unqualify(self, name, node):
        '''
        Removes the namespace declaration from an node name
        '''
        if node.prefix in node.nsmap:
            return name.replace('{{{}}}'.format(node.nsmap[node.prefix]), '')
        else:
            logging.warn('Could not find a namespace to node {}:{}'.format(node.prefix, node.tag))
            return ''