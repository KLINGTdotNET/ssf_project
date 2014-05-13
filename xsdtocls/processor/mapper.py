"""
Todo: rename this module
"""
from lxml import etree
from model import schemaElements

import logging

def map(tree):
    schema = tree.getroot()
    xsdns = None
    for prefix, ns in schema.nsmap.items():
        if ns == 'http://www.w3.org/2001/XMLSchema':
            xsdns = {'prefix': prefix, 'ns': ns}
    if not xsdns:
        logging.error('XSD namespace is not defined!')
        raise SystemExit('Terminating ...')
    tns = schema.attrib['targetNamespace']
    qualified = True if schema.attrib['elementFormDefault'] == 'qualified' else False
    print('qualified: {}\ntarget-namespace: {}\nnamespaces: {}'.format(qualified, tns, schema.nsmap))
    doc = {}
    doc['attributes'] = [_ for _ in schema.iterchildren(tag=qualify('attribute', xsdns['ns']))]
    doc['elements'] = [_ for _ in schema.iterchildren(tag=qualify('element', xsdns['ns']))]
    doc['complex_types'] = [_ for _ in schema.iterchildren(tag=qualify('complexType', xsdns['ns']))]
    doc['simple_types'] = [_ for _ in schema.iterchildren(tag=qualify('simpleType', xsdns['ns']))]
    for k, v in doc.items():
        logging.debug('{1} {0}'.format(k, len(v)))
    simple_types(doc['simple_types'], tns, xsdns)

def simple_types(simples, tns, xsdns):
    '''
    see http://www.w3.org/TR/2004/REC-xmlschema-2-20041028/datatypes.html#element-simpleType
    '''
    for simple in simples:
        if 'name' in simple.attrib.keys():
            name = simple.attrib['name']
            if len(simple):
                for child in simple:
                    if child.tag == qualify('restriction', xsdns['ns']):
                        simple_type_restriction(child, xsdns)
                    elif child.tag == qualify('list', xsdns['ns']):
                        simple_type_list()
                    elif child.tag ==qualify('union', xsdns['ns']):
                        simple_type_union()
                    else:
                        logging.debug('Unexpected element "{}" in "{}"'.format(child.tag, name))
            else:
                logging.debug('SimpleType "{}" is empty'.format(name))
        else:
            logging.debug('Nameless SimpleType in "{}"'.format(tns))

def simple_type_restriction(restriction, xsdns):
    base = restriction.attrib['base']
    content = {}
    if len(restriction):
        for child in restriction:
            tag = unqualify(child.tag, xsdns['ns'])
            #(minExclusive | minInclusive | maxExclusive | maxInclusive | totalDigits | fractionDigits | length | minLength | maxLength | enumeration | whiteSpace | pattern)
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
    pass

def simple_type_union():
    pass

def qualify(name, ns):
    return '{{{}}}{}'.format(ns, name)

def unqualify(name, ns):
    return name.replace('{{{}}}'.format(ns), '')