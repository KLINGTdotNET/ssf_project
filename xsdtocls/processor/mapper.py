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
    print(root.tag, root.attrib)
    doc = {}
    doc['attributes'] = [_ for _ in root.iterchildren(tag='{%s}attribute' % xsdns)]
    doc['elements'] = [_ for _ in root.iterchildren(tag='{%s}element' % xsdns)]
    doc['complex_types'] = [_ for _ in root.iterchildren(tag='{%s}complexType' % xsdns)]
    doc['simple_types'] = [_ for _ in root.iterchildren(tag='{%s}simpleType' % xsdns)]
    #
    for k, v in doc.items():
        logging.debug('{} has {} elements'.format(k, len(v)))
    #
    simple_types(doc['simple_types'])

def simple_types(simples):
    for simple in simples:
        if 'name' in simple.attrib.keys():
            #print(simple.attrib['name'])
            logging.debug(simple)
            pass
        else:
            logging.debug('{}')