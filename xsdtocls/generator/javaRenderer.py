import os
import logging
from urllib.parse import urlparse
from mako.template import Template
from mako.lookup import TemplateLookup
from mako.exceptions import RichTraceback

class Renderer():
    '''
    Java Renderer class
    '''

    def __init__(self, template_path):
        '''
        Args:
            template_path (str): Path to the directory where the Mako templates are stored
        '''
        self.lookup = TemplateLookup(directories=[template_path])
        self.typemap = {
            'int': 'Integer',
            'long': 'Long',
            'string': 'String',
            'boolean': 'Boolean',
            'decimal': 'Double'
        }

    def render(self, model, dest, overwrite):
        '''
        Args:
            model (dict): Model from classmapper that contains type and element definitions
            dest (str): A path that points to the destination where the generated class files should be stored
            overwrite (bool): If True then the existing output will be overwritten, otherwise not
        '''
        paths = self.prepare_project_structure(dest, model['tns'], overwrite)

        for key in model['types']:
            self.render_type_class(model['types'][key], model['tns'], paths)
        '''
        for key in model['elements']:
            self.render_element_class(model['elements'][key], model['tns'])
        '''
        '''
        for element in model['elements']:
            rendered_element = None
            classname = self.to_camel_case(element['name'])
            try:
                template = self.lookup.get_template('class.template')
                rendered_element = template.render(name=classname, toXML='"test"')
            except:
                traceback = RichTraceback()
                msg = 'Mako traceback:\n'
                for (filename, lineno, function, line) in traceback.traceback:
                    msg += 'File "{}" @ line "{}" in "{}"'.format(filename, lineno, function)
                    msg += '\n'
                msg += '"{}": "{}"'.format(str(traceback.error.__class__.__name__), traceback.error)
                logging.warn(msg)
            if rendered_element:
                path = filepath = os.path.join(paths['root'], paths['sources'], paths['package'], classname+'.java')
                self.write_to_file(rendered_element, path, classname)
        '''

    def render_type_class(self, type_class, tns, paths):
        '''
        Renders type definition as Java class
        '''
        classname = self.to_camel_case(type_class.name)
        render_args = {
            'name': classname,
            'fields': type_class.fields,
            'ordering': type_class.ordering,
            'serialiser': type_class.serialiser,
            'tns': tns,
            'typemap': self.typemap,
            'to_camel_case': self.to_camel_case,
            'base': type_class.base_class,
            'dependencies': type_class.dependencies,
            'package': self.get_package_name_from_url(tns)
        }
        template = self.lookup.get_template('type_class.template')
        rendered_template = self.render_template(template, render_args)
        if rendered_template:
            filepath = os.path.join(paths['root'], paths['sources'], paths['package'], classname+'.java')
            self.write_to_file(rendered_template, filepath, classname)

    def render_element_class(self, element_class, tns):
        pass

    def render_template(self, template, args):
        '''
        Calls template render engine
        '''
        try:
            return template.render(**args)
        except:
            traceback = RichTraceback()
            msg = 'Mako traceback:\n'
            for (filename, lineno, function, line) in traceback.traceback:
                msg += 'File "{}" @ line "{}" in "{}"'.format(filename, lineno, function)
                msg += '\n'
            msg += '"{}": "{}"'.format(str(traceback.error.__class__.__name__), traceback.error)
            logging.warn(msg)

    def write_to_file(self, rendered, path, classname):
        '''
        Writes a rendered template to a file

        Args:
            rendered (str): rendered template output
        '''
        with open(path, 'w') as f:
            try:
                f.write(rendered)
            except:
                pass

    def to_camel_case(self, string, first_up=True):
        '''
        Returns camel cased version of the argument *string*, f.e. foo_bar_baz will be foo_bar_baz

        Args:
            string (str): String that should be camel cased
            first_up (bool): First character will be capitalized, default is True
        '''
        camel_cased = ''
        splitted = string.split('_')
        start = 0
        if not first_up:
            camel_cased += splitted[0]
            start = 1
        if len(splitted) > 1:
            for i in range(start, len(splitted)):
                camel_cased += splitted[i][0].upper() + splitted[i][1:]
        else:
            camel_cased = string[0].upper() + string[1:]
        return camel_cased

    def prepare_project_structure(self, dest, tns, overwrite):
        '''
        Prepares the Java project structure and returns a dict containing the paths to the created directories

        Args:
            dest (str): destintation path where the generated output has to stored (given via command line parameter)
            tns (str): targetnamespace of the model
            overwrite (bool): If True then the files located in in the destination path will be overwritten
        '''
        paths = {}
        paths['root'] = os.path.join(dest, self.path_from_url(tns, '_'))
        if not os.path.isdir(paths['root']):
            logging.debug('Trying to create output dir "{}"'.format(paths['root']))
            try:
                os.makedirs(paths['root'])
            except os.error as e:
                logging.warn('Could not create output path "{}": {}!'.format(paths['root'], e))
        else:
            logging.warn('Output directory "{}" already exists!'.format(paths['root']))
            if overwrite:
                logging.info('Output contents will be overwritten!')
            else:
                raise SystemExit('No permission to overwrite existing output at "{}" was given, exiting ...'.format(dest))
        paths.update(self.create_project_structure(paths['root'], tns))  # update inserts k,v pairs from another dict
        return paths

    def create_project_structure(self, root, tns):
        '''
        Creates a default java program structure with a package folder named by the targetnamespace and returns the paths

        Args:
            root (str): project root
            tns (str): target namespace

        see: http://maven.apache.org/guides/introduction/introduction-to-the-standard-directory-layout.html
        '''
        paths = {}
        paths['sources'] = os.path.join('src', 'main', 'java')
        sources_path = os.path.join(root, paths['sources'])
        if not os.path.isdir(sources_path):
            try:
                os.makedirs(sources_path)
            except os.error as e:
                logging.warn(e)
        paths['package'] = self.create_package(sources_path, tns)
        return paths

    def get_package_name_from_url(self, ns):
        '''
        Returns the namespace url as Java package name

        Args:
            ns: namespace url
        '''
        url = urlparse(ns)
        return '.'.join(url.netloc.split('.')[::-1])

    def create_package(self, sources_path, tns):
        '''
        Creates package folders from the given targetnamespace below the source path and returns the path

        Args:
            sources_path (str): path to the source folder (f.e. 'src/main/java')
            tns (str): targetnamespace
        '''
        url = urlparse(tns)
        package = os.path.join(*tuple(url.netloc.split('.')[::-1]))
        full_path = os.path.join(sources_path, package)
        if not os.path.isdir(full_path):
            try:
                os.makedirs(full_path)
            except os.error as e:
                logging.warn(e)
        return package

    def path_from_url(self, url, replacement):
        '''
        Returns a path from a url by replacing colons with underscores and . with *replacement*

        Args:
            url (str): a URL
            replacement (str): string that replaces dots
        '''
        parsed = urlparse(url)
        root = parsed.netloc if not ':' in parsed.netloc else parsed.netloc.replace(':', '_')
        if parsed.path:
            subpath = parsed.path
            if os.sep in subpath:
                subpath = subpath.replace(os.sep, '')
            return os.path.join(root, subpath.replace('.', replacement))
        else:
            return root