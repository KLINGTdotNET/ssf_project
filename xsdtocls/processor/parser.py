from lxml import etree
# lxml.etree is in most parts compatible with the ElementTree of the STL, http://lxml.de/compatibility.html
# lxml supports XPath, XSLT, Relax NG, and XML Schema, which ElementTree does not.

def parse(url):
    """
    Returns an etree object generated from the schema under the url
    """
    try:
        try:
            return etree.parse(url)
        except etree.XMLSyntaxError as e:
            print(e)
            return None
    except OSError as e:
        print(e)
        return None

def tostr(tree):
    """
    Returns the string representation of the etree
    """
    return etree.tostring(tree, pretty_print=True)