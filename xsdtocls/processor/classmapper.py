import logging
from model import schemaElements

class ClassMapper():
    '''
    ClassMapper, contains methods to map the schema model to the class model
    '''

    def __init__(self, schemamodel):
        '''
        Args:
            schemamodel (dict): Output of schemamapper
        '''
        self.schemamodel = schemamodel

    def map(self):
        '''
        Returns a dict with the mapped attributes, elements and types
        '''
        model = {
            'tns': self.schemamodel['tns'],
            'attributes': {},
            'elements': {},
            'types': {}
        }

        for type_definition in self.schemamodel['types']:
            t = self.to_type_class(type_definition)
            if t:
                model['types'][t.name] = t

        for element_definition in self.schemamodel['elements']:
            e = self.to_element_class(element_definition)
            if e:
                model['elements'][e.name] = e

        return model

    def resolve_reference(self, ref):
        '''
        Resolves the reference pointed to by *ref*

        Args:
            ref (dict): type reference
        '''
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
        '''
        Returns the schemaElements.Type() instance containing the type definition of *schemaType*

        Args:
            schemaType (dict): schema model type definition
        '''
        name = schemaType['name']
        base = None
        #ns = tns
        fields = {}
        ordering = []
        dependencies = {
            'types': {}
        }
        if 'attributes' in schemaType:
            for attribute in schemaType['attributes']:
                if 'ref' in attribute:
                    # resolve reference on element
                    resolved = self.resolve_reference(attribute['ref'])
                    fields[resolved['name']] = {
                        'type': resolved['type'],
                        'isAttribute': True
                    }
                    if resolved['type']['ns'] == self.schemamodel['tns']:
                        if 'anonymous' not in resolved['type']:
                            dependencies['types'][resolved['type']['name']] = resolved['type']
                else:
                    fields[attribute['name']] = {
                        'type': attribute['type'],
                        'isAttribute': True
                    }
                    if attribute['type']['ns'] == self.schemamodel['tns']:
                        if 'anonymous' not in attribute['type']:
                            dependencies['types'][attribute['type']['name']] = attribute['type']
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
                        fields['value'] = base['name']
                elif key == 'extends':
                    base = content['extends']
                elif key == 'attributes':
                    for attribute in content['attributes']:
                        fields[attribute['name']] = {
                            'type': attribute['type'],
                            'isAttribute': True
                        }
                        if attribute['type']['ns'] == self.schemamodel['tns']:
                            if 'anonymous' not in attribute['type']:
                                dependencies['types'][attribute['type']['name']] = attribute['type']
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
                                    if element['type']['ns'] == self.schemamodel['tns']:
                                        if 'anonymous' not in element['type']:
                                            dependencies['types'][element['type']['name']] = element['type']
                                elif 'ref' in element:
                                    # resolve reference on element
                                    resolved_element = self.resolve_reference(element['ref'])
                                    if resolved_element:
                                        fields[resolved_element['name']] = {
                                            'type': resolved_element['type'],
                                            'occurance': resolved_element['occurance']
                                        }
                                    if resolved_element['type']['ns'] == self.schemamodel['tns']:
                                        if 'anonymous' not in resolved_element['type']:
                                            dependencies['types'][resolved_element['type']['name']] = resolved_element['type']
                                else:
                                    logging.debug('Unexpected element: "{}"'.format(element))
                else:
                    logging.debug('Unexpected element "{}"'.format(key))
        if 'ordering' in schemaType:
            ordering = schemaType['ordering']
            if 'sequence' in schemaType['ordering']:
                for seq_element in  schemaType['ordering']['sequence']:
                    if 'anonymous' not in seq_element['type']:
                        if seq_element['type']['ns'] == self.schemamodel['tns']:
                            dependencies['types'][seq_element['type']['name']] = seq_element['type']
        type_class = schemaElements.Type()
        type_class.name = name
        type_class.base_class = base
        if base and base['ns'] == self.schemamodel['tns']:
            dependencies['types'][base['name']] = base
        type_class.fields = fields
        type_class.ordering = ordering
        type_class.serialiser = self.generate_toXML_method(type_class)
        type_class.dependencies = dependencies

        return type_class

    def to_element_class(self, schemaElement):
        '''
        Returns the schemaElements.Element() instance containing the element definition of *schemaElement*

        Args:
            schemaElement (dict): schema model element definition
        '''

        element_class = schemaElements.Element()
        dependencies = {
            'types': {}
        }
        value = {}

        if 'anonymous' in schemaElement['type'] and schemaElement['type']['anonymous']:
            logging.debug('Skipping anonymous definition')
        else:
            element_class.name = schemaElement['name']
            if schemaElement['type']['ns'] == self.schemamodel['tns']:
                element_class.value = schemaElement['type']
                dependencies['types'][schemaElement['type']['name']] = schemaElement['type']
            elif schemaElement['type']['ns'] == 'http://www.w3.org/2001/XMLSchema':
                element_class.value = schemaElement['type']
            else:
                logging.debug('Unexpected type namespace "{}" for element "{}"'.format(schemaElement['type']['ns'], schemaElement['name']))
            element_class.serialiser = ' + '.join(['"<{}>"'.format(element_class.name), 'this.value', '"</{}>"'.format(element_class.name)])
            element_class.dependencies = dependencies
            return element_class

    def generate_toXML_method(self, t):
        '''
        Returns the return statement for the serialisation method of the Type class

        Args:
            t (schemaElement.Type): type definition
        '''
        concat = []
        for field_name in t.fields:
            # only one field?
            field_type = t.fields[field_name]
            concat.append(field_name + '.toString()')
        for order in t.ordering:
            if order == 'sequence':
                sequence = t.ordering[order]
                for element in sequence:
                    parts = []
                    # check for type namespace, if tns then element['name'].toXML() else element or something else when anonymous
                    if 'anonymous' in element['type']:
                        logging.debug('Anonymous type definitions are not implemented yet!')
                    else:
                        if element['type']['ns'] == self.schemamodel['tns']:
                            parts.append('this.' + element['name'] + '.toXML()')
                        else:
                            parts.append('"<{}>"'.format(element['name']))
                            parts.append('this.' + element['name'])
                            parts.append('"</{}>"'.format(element['name']))
                        concat.append(' + '.join(parts))
        return ' + '.join(concat)