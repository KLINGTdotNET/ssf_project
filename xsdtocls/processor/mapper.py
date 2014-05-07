"""
Todo: rename this module
"""
from model import types

def map(tree):
    root = tree.getroot()
    xsdns = root.nsmap['xsd']
    print(root.tag, root.attrib)
    elements = [_ for _ in root.iterchildren(tag='{%s}element' % xsdns)]
    complex_types = [_ for _ in root.iterchildren(tag='{%s}complexType' % xsdns)]
    simple_types = [_ for _ in root.iterchildren(tag='{%s}simpleType' % xsdns)]
    for simple_type in simple_types:
        print(simple_type.tag, simple_type.attrib)