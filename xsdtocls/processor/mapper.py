"""
Todo: rename this module
"""
from lxml import etree
from model import types
from collections import deque

import logging

def map(tree):
    root = tree.getroot()
    xsdns = root.nsmap['xsd']
    ns = root.attrib['targetNamespace']
    qualified = True if root.attrib['elementFormDefault'] == 'qualified' else False
    print('qualified: {}\ntarget-namespace: {}\nnamespaces: {}'.format(qualified, ns, root.nsmap))
    doc = {}
    doc['attributes'] = [_ for _ in root.iterchildren(tag='{%s}attribute' % xsdns)]
    doc['elements'] = [_ for _ in root.iterchildren(tag='{%s}element' % xsdns)]
    doc['complex_types'] = [_ for _ in root.iterchildren(tag='{%s}complexType' % xsdns)]
    doc['simple_types'] = [_ for _ in root.iterchildren(tag='{%s}simpleType' % xsdns)]
    #
    for k, v in doc.items():
        logging.debug('{1} {0}'.format(k, len(v)))
    #
    simple_types(doc['simple_types'])

def simple_types(simples):
    for simple in simples:
        if 'name' in simple.attrib.keys():
            #print(simple.attrib['name'])
            pass
        else:
            logging.debug('{}')