import logging
from model import schemaElements

import pprint
pp = pprint.PrettyPrinter(indent=4)

class ClassMapper():

    def __init__(self, schemamodel):
        self.schemamodel = schemamodel

    def map(self):
        model = {
            'tns': self.schemamodel['tns'],
            'attributes': {},
            'elements': {},
            'types': {}
        }

        for type in self.schemamodel['types']:
            t = self.to_type_class(type)
            toXML = self.generate_toXML_method(t)
            model['types'][t.name] = t

        for element in self.schemamodel['elements']:
            '''
            if element['type']['ns'] == model['tns']:
                pass
            else:
                logging.debug(element)
            '''
            if 'anonymous' in element['type']:
                pp.pprint(element)
            elif element['type']['ns'] == model['tns']:
                # replace type with declaration
                t = None
                for schemaType in self.schemamodel['types']:
                    if schemaType['name'] == element['type']['name']:
                        t = schemaType
                if not t:
                    logging.debug('Could not find: "{}"'.format(element['type']))
                else:
                    element['type'] = t
                    pp.pprint(element)
            else:
                pp.pprint(element)

        model['elements'] = self.schemamodel['elements']

        return model

    def resolve_reference(self, ref):
        if ref['ns'] == self.schemamodel['tns']:
            for type in self.schemamodel['types']:
                if type['name'] == ref['reference']:
                    return type
            for element in self.schemamodel['elements']:
                if element['name'] == ref['reference']:
                    return element
        else:
            if ref['prefix'] == 'xlink' and ref['reference'] == 'href':
                return {
                    'name': 'href',
                    'type':  {
                        'name': 'string',
                        'ns': 'http://www.w3.org/2001/XMLSchema',
                        'prefix': 'xs'
                    }
                }

    def to_type_class(self, schemaType):
        name = schemaType['name']
        base = None
        #ns = tns
        fields = {}
        ordering = []
        if 'attributes' in schemaType:
            for attribute in schemaType['attributes']:
                if 'ref' in attribute:
                    # resolve reference on element
                    resolved = self.resolve_reference(attribute['ref'])
                    fields[resolved['name']] = {
                        'type': resolved['type'],
                        'isAttribute': True
                    }
                else:
                    fields[attribute['name']] = {
                        'type': attribute['type'],
                        'isAttribute': True
                    }
        if 'content' in schemaType:
            content = schemaType['content']
            for key in content:
                if key == 'enumeration':
                    fields['enum'] = content[key]
                elif key == 'restrictions':
                    if len(content['restrictions']):
                        fields['restrictions'] = content[key]
                elif key == 'base':
                    base = content['base']
                    if len(content) == 1:
                        # base declares only the type inside of the element
                        fields['value'] = base['name']
                elif key == 'extends':
                    base = content['extends']
                elif key == 'attributes':
                    for attribute in content['attributes']:
                        fields[attribute['name']] = {
                            'type': attribute['type'],
                            'isAttribute': True
                        }
                elif key == 'ordering':
                    for order in content[key]:
                        if order == 'sequence':
                            sequence = content[key]['sequence']
                            for element in sequence:
                                if 'name' in element:
                                    ordering.append(element['name'])
                                    fields[element['name']] = {
                                        'type': element['type'],
                                        'occurance': element['occurance']
                                    }
                                elif 'ref' in element:
                                    # resolve reference on element
                                    self.resolve_reference(element['ref'])
                                else:
                                    logging.debug('Unexpected element: "{}"'.format(element))
                        else:
                            logging.debug(order)
                else:
                    logging.debug('Unexpected element "{}"'.format(key))
        if 'ordering' in schemaType:
            ordering = schemaType['ordering']
        type = schemaElements.Type()
        type.name = name
        type.base_class = base
        #type.ns = tns
        type.fields = fields
        type.ordering = ordering

        #pp.pprint((name, base, fields, ordering))

        return type

    def generate_toXML_method(self, t):
        pass