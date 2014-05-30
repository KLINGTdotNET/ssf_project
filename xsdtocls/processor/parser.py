from lxml import etree
from os.path import isfile

def parse(url):
    '''
    Returns an etree object that contains the XML content given under *url*

    Args:
        url (str): A url to a XML document
    '''
    try:
        try:
            return etree.parse(url)
        except etree.XMLSyntaxError as e:
            print(e)
            return None
    except OSError as e:
        print(e)
        return None
