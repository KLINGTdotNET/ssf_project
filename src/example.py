from io import StringIO
from lxml import etree
from pprint import pprint

f = StringIO('''
<xsd:schema xmlns:xsd="http://www.w3.org/2001/XMLSchema">
<xsd:element name="a" type="AType"/>
<xsd:complexType name="AType">
<xsd:sequence>
<xsd:element name="b" type="xsd:string" />
</xsd:sequence>
</xsd:complexType>
</xsd:schema>
''')

xmlschema_doc = etree.parse(f)
xmlschema = etree.XMLSchema(xmlschema_doc)

pprint(dir(xmlschema_doc))
pprint(dir(xmlschema))
