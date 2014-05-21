"""
Todo: rename this module
"""
from lxml import etree
from model import schemaElements

import logging

def map(tree):
    root = tree.getroot()
    qualified = True if root.attrib['elementFormDefault'] == 'qualified' else False
    tns = root.attrib['targetNamespace'] if 'targetNamespace' in root.attrib else ''
    print('qualified: {}\ntarget-namespace: {}\nnamespaces: {}'.format(qualified, tns, root.nsmap))
    schema = {}
    # note that if the schema element is the parent node, then the actual note contains a declaration
    schema['imports'] = [_ for _ in root.iterchildren(tag=qualify('import', root))]
    schema['attributes'] = [_ for _ in root.iterchildren(tag=qualify('attribute', root))]
    schema['elements'] = [_ for _ in root.iterchildren(tag=qualify('element', root))]
    schema['complex_types'] = [_ for _ in root.iterchildren(tag=qualify('complexType', root))]
    schema['simple_types'] = [_ for _ in root.iterchildren(tag=qualify('simpleType', root))]

    model = {
        'tns': tns,
        'qualified': qualified,
        'nsmap': root.nsmap,
        'attributes': [],
        'types': [],
        'elements': []
    }

    for k, v in schema.items():
        logging.debug('{1} {0}'.format(k, len(v)))
    for schema_import in schema['imports']:
        pass    # todo
    for attribute in schema['attributes']:
        model['attributes'].append(map_attribute(attribute))
    for simple_type in schema['simple_types']:
        model['types'].append(map_simple_type(simple_type))
    for complex_type in schema['complex_types']:
        model['types'].append(map_complex_type(complex_type))
    for element in schema['elements']:
        model['elements'].append(map_element(element))
    return model

def map_import(schema_import):
    '''
    lxml resolves schema imports only when a validator is created through etree.XMLSchema()
    '''
    return schema_import.attrib['namespace']

def map_type(type, nsmap):
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

def map_attribute(attribute):
    '''
    see http://www.w3.org/TR/xmlschema-1/#cAttribute_Declarations
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
            content['type'] = map_type(attribute.attrib['type'], attribute.nsmap)
        elif len(attribute):
            if attribute[0].tag == qualify('simpleType', attribute[0]):
                content['type'] = map_simple_type(attribute[0])
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

def map_simple_type(simple):
    '''
    see http://www.w3.org/TR/2004/REC-xmlschema-2-20041028/datatypes.html#element-simpleType
    '''
    content = {}
    parent = simple.getparent()
    if 'name' in simple.attrib.keys():
        content['name'] = simple.attrib['name']
    elif parent.tag is qualify('schema', parent):
        logging.warn('Anonymous simpleType as direct child of "schema" element!')
        return {}
    if len(simple):
        for child in simple:
            if child.tag == qualify('restriction', child):
                content['content'] = simple_type_restriction(child)
            elif child.tag == qualify('list', child):
                content['content'] = simple_type_list()
            elif child.tag == qualify('union', child):
                content['content'] = simple_type_union()
            else:
                logging.debug('Unexpected element "{}" in "{}"'.format(child.tag, name))
    else:
        logging.debug('SimpleType "{}" is empty'.format(name))
    return content

def simple_type_restriction(restriction):
    '''
    see http://www.w3.org/TR/2004/REC-xmlschema-2-20041028/datatypes.html#element-restriction
    '''
    content = {'base': map_type(restriction.attrib['base'], restriction.nsmap)}
    if len(restriction):
        for child in restriction:
            tag = unqualify(child.tag, child)
            if tag == 'enumeration':
                if not 'enumeration' in content:
                    content['enumeration'] = []
                content['enumeration'].append(child.attrib['value'])
            elif 'max' in tag or 'min' in tag:
                ltag = tag.lower()
                if 'exclusive' in ltag:
                    logging.warn('Implement me!')
                elif 'inclusive' in ltag:
                    logging.warn('Implement me!')
                elif 'length' in ltag:
                    logging.warn('Implement me!')
                else:
                    logging.debug('Unsupported tag "{}" in SimpleType restriction'.format(child.tag))
            else:
                logging.debug('Unsupported tag "{}" in SimpleType'.format(child.tag))
    return content

def simple_type_list():
    logging.warn('Implement me!')

def simple_type_union():
    logging.warn('Implement me!')

def map_complex_type(complex):
    '''
    see http://www.w3.org/TR/xmlschema-1/#Complex_Type_Definitions
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
            unqualified = unqualify(child.tag, child)
            if 'attribute' == unqualified:
                if not 'attributes' in content:
                    content['attributes'] = []
                content['attributes'].append(map_attribute(child))
            elif 'complexContent' == unqualified:
                if 'content' not in content:
                    content['content'] = []
                # replace this with extension/restriction
                content['content'].append(map_complex_content(child))
            elif 'sequence' == unqualified:
                content['ordering'] = map_sequence(child)
            elif 'simpleContent' == unqualified:
                if 'content' not in content:
                    content['content'] = []
                content['content'].append(map_simple_content(child))
            elif 'all' == unqualified:
                # elements can occur in any order
                content['all'] = map_sequence(child)
            else:
                logging.debug('Unexpected element "{}"'.format(unqualified))
    return content

def map_complex_content(complex):
    content = {}
    if complex[0].tag == qualify('extension', complex[0]):
        content['extends'] = {
            'base': map_type(complex[0].attrib['base'], complex[0].nsmap)
        }
    elif complex[0].tag == qualify('restriction', complex[0]):
        content['restricts'] = {
            'base': map_type(complex[0].attrib['base'], complex[0].nsmap)
        }
    else:
        logging.debug('Bad complexContent definition with direct child {}'.format(simple[0].tag))
    for child in complex[0]:
        if child.tag == qualify('sequence', child):
            content['ordering'] = map_sequence(child)
        elif child.tag == qualify('attribute', child):
            if not 'content' in content:
                content['content'] = []
            content['content'].append(map_attribute(child))
    return content

def map_sequence(element):
    ordering = {}
    # elements must appear in that order
    for child in element:
        if child.tag == qualify('element', child):
            if 'sequence' not in ordering:
                ordering['sequence'] = []
            ordering['sequence'].append(map_element(child))
        elif child.tag == qualify('choice', child):
            # http://msdn.microsoft.com/de-de/library/ms256109(v=vs.110).aspx
            # only of of the contained elements should be present!
            for choiceElement in child:
                if 'choice' not in ordering:
                    ordering['choice'] = []
                ordering['choice'].append(map_element(choiceElement))
        elif child.tag == qualify('any', child):
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

def map_simple_content(simple):
    '''
    see http://msdn.microsoft.com/de-de/library/ms256106(v=vs.110).aspx
    '''
    content = {}
    unqualified = unqualify(simple[0].tag, simple[0])
    if unqualified == 'extension':
        content['extends'] = {
            'base': map_type(simple[0].attrib['base'], simple[0].nsmap)
        }
    elif unqualified == 'restriction':
        content['restricts'] = {
            'base': map_type(simple[0].attrib['base'], simple[0].nsmap)
        }
    else:
        logging.debug('Bad simpleContent definition with direct child {}'.format(simple[0].tag))
    if len(simple[0]):
        for child in simple[0]:
            unqualified = unqualify(child.tag, child)
            if unqualified == 'attribute':
                if 'attributes' not in content:
                    content['attributes'] = []
                content['attributes'].append(map_attribute(child))
            else:
                print(child.tag, child.attrib)
    else:
        logging.debug('Empty simpleContent!')
    return content

def map_element(element):
    content = {}
    for key in element.attrib:
        if key == 'name':
            content['name'] = element.attrib[key]
        elif key == 'type':
            content['type'] = map_type(element.attrib[key], element.nsmap)
        elif 'occurs' in key.lower():
            content['occurance'] = {
                'min': 1,
                'max': 1
            }
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
            if child.tag == qualify('complexType', child):
                content['type'] = map_complex_type(child)
            elif child.tag == qualify('simpleType', child):
                content['type'] = map_simple_type(child)
            else:
                logging.debug('Unexpected child "{}" of element "{}" with name "{}".'.format(child.tag, element.tag, element.attrib['name']))
    return content

def qualify(name, node):
    if node.prefix in node.nsmap:
        return '{{{}}}{}'.format(node.nsmap[node.prefix], name)
    else:
        logging.warn('Could not find a namespace to node {}:{}'.format(node.prefix, node.tag))
        return ''

def unqualify(name, node):
    if node.prefix in node.nsmap:
        return name.replace('{{{}}}'.format(node.nsmap[node.prefix]), '')
    else:
        logging.warn('Could not find a namespace to node {}:{}'.format(node.prefix, node.tag))
        return ''