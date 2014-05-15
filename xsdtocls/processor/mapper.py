"""
Todo: rename this module
"""
from lxml import etree
from model import schemaElements

import logging

def map(tree):
    root = tree.getroot()
    xsdns = None
    for prefix, ns in root.nsmap.items():
        if ns == 'http://www.w3.org/2001/XMLSchema':
            xsdns = {'prefix': prefix, 'ns': ns}
    if not xsdns:
        logging.error('XSD namespace is not defined!')
        raise SystemExit('Terminating ...')
    tns = root.attrib['targetNamespace']
    qualified = True if root.attrib['elementFormDefault'] == 'qualified' else False
    print('qualified: {}\ntarget-namespace: {}\nnamespaces: {}'.format(qualified, tns, root.nsmap))
    schema = {}
    # note that if the schema element is the parent node, then the actual note contains a declaration
    schema['imports'] = [_ for _ in root.iterchildren(tag=qualify('import', xsdns['ns']))]
    schema['attributes'] = [_ for _ in root.iterchildren(tag=qualify('attribute', xsdns['ns']))]
    schema['elements'] = [_ for _ in root.iterchildren(tag=qualify('element', xsdns['ns']))]
    schema['complex_types'] = [_ for _ in root.iterchildren(tag=qualify('complexType', xsdns['ns']))]
    schema['simple_types'] = [_ for _ in root.iterchildren(tag=qualify('simpleType', xsdns['ns']))]
    for k, v in schema.items():
        logging.debug('{1} {0}'.format(k, len(v)))

    for schema_import in schema['imports']:
        map_import(schema_import, tns, xsdns)
    for attribute in schema['attributes']:
        map_attribute(attribute, tns, xsdns)
    for simple_type in schema['simple_types']:
        map_simple_type(simple_type, tns, xsdns)
    for complex_type in schema['complex_types']:
        map_complex_type(complex_type, tns, xsdns)
    for element in schema['elements']:
        map_element(element, tns, xsdns)

def map_import(schema_import, tns, xsdns):
    print(schema_import.tag, schema_import.attrib, len(schema_import))

def map_type(type, tns, xsdns):
    prefix, name = type.split(':')
    ns = ''
    if prefix == 'tns':
        ns = tns
    elif prefix == xsdns['prefix']:
        ns = xsdns['ns']
    else:
        logging.debug('Unknown namespace prefix: {}'.format(prefix))
    return {
        'prefix': prefix,
        'name': name,
        'ns': ns
    }

def map_attribute(attribute, tns, xsdns):
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
            content['type'] = map_type(attribute.attrib['type'], tns, xsdns)
        elif len(attribute):
            if attribute[0].tag == qualify('simpleType', xsdns['ns']):
                content['type'] = map_simple_type(attribute[0], tns, xsdns)
            else:
                logging.debug('Bad attribute type {}'.format(attribute[0].tag))
        else:
            logging.debug('Wether type-declration nor type-definition in attribute {}'.format(name))
    elif 'ref' in attribute.attrib:
        print(attribute.attrib.items())
        print(len(attribute.attrib))
        content['ref'] = attribute.attrib['ref']
        print(attribute.attrib)
        logging.debug('Implement me!')
    else:
        logging.debug('Wether "reference" nor a "explicit declaration"!')
    return content

def map_simple_type(simple, tns, xsdns):
    '''
    see http://www.w3.org/TR/2004/REC-xmlschema-2-20041028/datatypes.html#element-simpleType
    '''
    content = {}
    if 'name' in simple.attrib.keys():
        content['name'] = simple.attrib['name']
    elif simple.getparent().tag is qualify('schema', xsdns['ns']):
        logging.warn('Anonymous simpleType as direct child of "schema" element!')
        return {}
    if len(simple):
        for child in simple:
            if child.tag == qualify('restriction', xsdns['ns']):
                content = simple_type_restriction(child, tns, xsdns)
            elif child.tag == qualify('list', xsdns['ns']):
                content = simple_type_list()
            elif child.tag == qualify('union', xsdns['ns']):
                content = simple_type_union()
            else:
                logging.debug('Unexpected element "{}" in "{}"'.format(child.tag, name))
    else:
        logging.debug('SimpleType "{}" is empty'.format(name))
    return content

def simple_type_restriction(restriction, tns, xsdns):
    '''
    see http://www.w3.org/TR/2004/REC-xmlschema-2-20041028/datatypes.html#element-restriction
    '''
    content = {'base': map_type(restriction.attrib['base'], tns, xsdns)}
    if len(restriction):
        for child in restriction:
            tag = unqualify(child.tag, xsdns['ns'])
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

def map_complex_type(complex, tns, xsdns):
    '''
    see http://www.w3.org/TR/xmlschema-1/#Complex_Type_Definitions
    '''
    content = {}
    if 'name' in complex.attrib:
        content['name'] = complex.attrib['name']
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
                unqualified = unqualify(child.tag, xsdns['ns'])
                if 'attribute' == unqualified:
                    if not 'attributes' in content:
                        content['attributes'] = []
                    content['attributes'].append(map_attribute(child, tns, xsdns))
                elif 'complexContent' == unqualified:
                    pass
                elif 'sequence' == unqualified:
                    # elements must appear in that order
                    pass
                elif 'simpleContent' == unqualified:
                    if 'content' not in content:
                        content['content'] = []
                    content['content'].append(map_simple_content(child, tns, xsdns))
                elif 'all' == unqualified:
                    # elements can occur in any order
                    pass
                else:
                    logging.debug('Unexpected element "{}"'.format(unqualified))
            pass
    else:
        pass
        # anonymous (local) type definition

def map_simple_content(simple, tns, xsdns):
    '''
    see http://msdn.microsoft.com/de-de/library/ms256106(v=vs.110).aspx
    '''
    content = {}
    unqualified = unqualify(simple[0].tag, xsdns['ns'])
    if unqualified == 'extension':
        content['extends'] = {
            'base': map_type(simple[0].attrib['base'], tns, xsdns)
        }
    elif unqualified == 'restriction':
        content['restricts'] = {
            'base': map_type(simple[0].attrib['base'], tns, xsdns)
        }
    else:
        logging.debug('Bad simpleContent definition with direct child {}'.format(simple[0].tag))
    if len(simple[0]):
        for child in simple[0]:
            unqualified = unqualify(child.tag, xsdns['ns'])
            if unqualified == 'attribute':
                if 'attributes' not in content:
                    content['attributes'] = []
                content['attributes'].append(map_attribute(child, tns, xsdns))
            else:
                print(child.tag, child.attrib)
    else:
        logging.debug('Empty simpleContent!')
    return content

def map_element(element, tns, xsdns):
    pass

def qualify(name, ns):
    return '{{{}}}{}'.format(ns, name)

def unqualify(name, ns):
    return name.replace('{{{}}}'.format(ns), '')