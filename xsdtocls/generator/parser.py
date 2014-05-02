from lxml import etree

def parse(url):
    """
    Returns an etree object generated from the schema under the url
    """
    try:
        return etree.parse(url)
    except OSError as e:
        print(e)
        return None

def tostr(tree):
    """
    Returns the string representation of the etree
    """
    return etree.tostring(tree)