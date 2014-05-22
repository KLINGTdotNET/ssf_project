class Element():
    pass

class Type():
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
        self._modifiers = []
        self._fields = {} # elements?

    @property
    def name(self):
        return _name

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
