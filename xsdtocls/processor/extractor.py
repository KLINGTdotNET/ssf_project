"""
Todo: rename this module
"""

def extract(tree):
    root = tree.getroot()
    xsdns = root.nsmap['xsd']
    print(root.tag, root.attrib)
    elements = [_ for _ in root.iterchildren(tag='{%s}element' % xsdns)]
    complex_types = [_ for _ in root.iterchildren(tag='{%s}complexType' % xsdns)]
    simple_types = [_ for _ in root.iterchildren(tag='{%s}simpleType' % xsdns)]
    for element in elements:
        print(element.tag, element.attrib)
        if not 'type' in element.attrib:
            for child in element.getchildren():
                print('\thas anonymous type', child.tag)