#!/usr/bin/env python3

from tools import cli, read_url

def main():
    args = cli.get_args()
    content = read_url.read(args.url)
    print(content)

if __name__ == '__main__':
    main()

"""
from lxml import etree

filepath = "/home/andreas/personal/dev/python/ssf_project/resources/facebook.xsd"
url = 'http://api.facebook.com/1.0/facebook.xsd'

with open(filepath, 'r') as file:
    xmlschema_doc = etree.parse(file)
    xmlschema = etree.XMLSchema(xmlschema_doc)

print(etree.tostring(xmlschema_doc, pretty_print=True))
"""