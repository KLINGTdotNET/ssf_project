class SchemaElement():
    def name(self):
        raise NotImplementedError()
    def modifiers(self):
        raise NotImplementedError()
    def serialiser(self):
        raise NotImplementedError()
    def dependencies(self):
        raise NotImplementedError()

class Element(SchemaElement):

    def __init__(self):
        self._name = ''
        self._ns = ''
        self._modifiers = {
            'value': 'private',
            'methods': 'public'
        }
        self._value = {}
        self._serialiser = ''
        self._dependencies = {}

    @property
    def name(self):
        return self._name
    @name.setter
    def name(self, value):
        self._name = value

    @property
    def value(self):
        return self._value
    @value.setter
    def value(self, value):
        self._value = value

    @property
    def modifiers(self):
        return self._modifiers
    @modifiers.setter
    def modifiers(self, value):
        self._modifiers = value

    @property
    def serialiser(self):
        return self._serialiser
    @serialiser.setter
    def serialiser(self, value):
        self._serialiser = value

    @property
    def dependencies(self):
        return self._dependencies
    @dependencies.setter
    def dependencies(self, value):
        self._dependencies = value


class Type(SchemaElement):
    '''
    This class should map the xsd type definition to a class model

    name: name of the class
    ns: namespace
    base_class: name of the base class from which this class inherits
    modifers: class modifiers, f.e. public, abstract ...
    fields: class fields
    '''

    def __init__(self):
        self._name = ''
        self._ns = ''
        self._base_class = None
        self._modifiers = {
            'fields': 'private',
            'methods': 'public'
        }
        self._fields = {} # elements?
        self._ordering = []
        self._serialiser = ''
        self._dependencies = {}

    @property
    def name(self):
        return self._name
    @name.setter
    def name(self, value):
        self._name = value

    @property
    def ns(self):
        return self._ns
    @ns.setter
    def ns(self, value):
        self._ns = value

    @property
    def modifiers(self):
        return self._modifiers
    @modifiers.setter
    def modifiers(self, value):
        self._modifiers = value

    @property
    def base_class(self):
        return self._base_class
    @base_class.setter
    def base_class(self, value):
        self._base_class = value

    @property
    def fields(self):
        return self._fields
    @fields.setter
    def fields(self, value):
        self._fields = value

    @property
    def ordering(self):
        return self._ordering
    @ordering.setter
    def ordering(self, value):
        self._ordering = value

    @property
    def serialiser(self):
        return self._serialiser
    @serialiser.setter
    def serialiser(self, value):
        self._serialiser = value

    @property
    def dependency(self):
        return self._dependency
    @dependency.setter
    def dependency(self, value):
        self._dependency = value
