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
    schema['attributes'] = [_ for _ in root.iterchildren(tag=qualify('attribute', xsdns['ns']))]
    schema['elements'] = [_ for _ in root.iterchildren(tag=qualify('element', xsdns['ns']))]
    schema['complex_types'] = [_ for _ in root.iterchildren(tag=qualify('complexType', xsdns['ns']))]
    schema['simple_types'] = [_ for _ in root.iterchildren(tag=qualify('simpleType', xsdns['ns']))]
    for k, v in schema.items():
        logging.debug('{1} {0}'.format(k, len(v)))
    simple_types(schema['simple_types'], tns, xsdns)
    attributes(schema['attributes'], tns, xsdns)

def attributes(attributes, tns, xsdns):
    '''
    see http://www.w3.org/TR/xmlschema-1/#cAttribute_Declarations
    '''
    for attribute in attributes:
        if 'name' in attribute.attrib:
            name = attribute.attrib['name']
            if 'fixed' in attribute.attrib:
                fixed = attribute.attrib['fixed']
            if 'default' in attribute.attrib:
                default = attribute.attrib['default']
            if 'use' in attribute.attrib:
                # optional, required or prohibited
                use = attribute.attrib['use']
            if len(attribute):
                # type definition in child nodes (must be a SimpleType)
                pass
            else:
                type = attribute.attrib['type']
        elif 'ref' in attribute.attrib:
            console.debug('Implement me!')
        else:
            console.debug('Wether "reference" nor a "explicit declaration"!')


def simple_types(simples, tns, xsdns):
    '''
    see http://www.w3.org/TR/2004/REC-xmlschema-2-20041028/datatypes.html#element-simpleType
    '''
    simple_types = []
    for simple in simples:
        if 'name' in simple.attrib.keys():
            name = simple.attrib['name']
            content = {}
            if len(simple):
                for child in simple:
                    if child.tag == qualify('restriction', xsdns['ns']):
                        content = simple_type_restriction(child, xsdns)
                    elif child.tag == qualify('list', xsdns['ns']):
                        content = simple_type_list()
                    elif child.tag ==qualify('union', xsdns['ns']):
                        content = simple_type_union()
                    else:
                        logging.debug('Unexpected element "{}" in "{}"'.format(child.tag, name))
            else:
                logging.debug('SimpleType "{}" is empty'.format(name))
        else:
            logging.debug('Nameless SimpleType in "{}"'.format(tns))
        # create object of class SimpleType
        simple_types.append((name, content))
    return simple_types

def simple_type_restriction(restriction, xsdns):
    '''
    see http://www.w3.org/TR/2004/REC-xmlschema-2-20041028/datatypes.html#element-restriction
    '''
    content = {'base': restriction.attrib['base']}
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

def qualify(name, ns):
    return '{{{}}}{}'.format(ns, name)

def unqualify(name, ns):
    return name.replace('{{{}}}'.format(ns), '')