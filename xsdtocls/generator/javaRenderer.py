import os
import logging
from urllib.parse import urlparse
from mako.template import Template
from mako.lookup import TemplateLookup
from mako.exceptions import RichTraceback

class Renderer():
    def __init__(self, template_path):
        self.lookup = TemplateLookup(directories=[template_path], output_encoding='utf-8')

    def render(self, model, path):
        paths = {}
        paths['root'] = os.path.join(path, self.path_from_url(model['tns'], '_'))
        if not os.path.isdir(paths['root']):
            try:
                logging.debug('Trying to create output dir "{}"'.format(paths['root']))
                os.makedirs(paths['root'])
            except os.error as e:
                logging.warn('Could not create output path "{}"!'.format(paths['root']))
                print(e)
        else:
            logging.warn('Output directory "{}" already exists!'.format(paths['root']))
            # implement overwrite flag
        for key, value in self.create_project_structure(paths['root'], model['tns']).items():
            paths[key] = value
        for element in model['elements']:
            try:
                template = self.lookup.get_template('class.template')
                logging.debug(template.render(name=self.toCamelCase(element['name'])))
            except:
                traceback = RichTraceback()
                msg = 'Mako traceback:\n'
                for (filename, lineno, function, line) in traceback.traceback:
                    msg += 'File "{}" @ line "{}" in "{}"'.format(filename, lineno, function)
                    msg += '\n'
                msg += '"{}": "{}"'.format(str(traceback.error.__class__.__name__), traceback.error)
                logging.warn(msg)

    def toCamelCase(self, name):
        camelCased = ''
        splitted = name.split('_')
        camelCased += splitted[0]
        if len(splitted) > 1:
            for i in range(1, len(splitted)):
                camelCased += splitted[i][0].upper() + splitted[i][1:]
        return camelCased

    def create_project_structure(self, root, tns):
        # create package layout, see http://maven.apache.org/guides/introduction/introduction-to-the-standard-directory-layout.html
        paths = {}
        paths['sources'] = os.path.join('src', 'main', 'java')
        sources_path = os.path.join(root, paths['sources'])
        if not os.path.isdir(sources_path):
            try:
                os.makedirs(sources_path)
            except os.error as e:
                print(e)
        paths['package'] = self.create_package(sources_path, tns)
        return paths

    def create_package(self, root, tns):
        url = urlparse(tns)
        package = os.path.join(*tuple(url.netloc.split('.')[::-1]))
        full_path = os.path.join(root, package)
        if not os.path.isdir(full_path):
            try:
                os.makedirs(full_path)
            except os.error as e:
                print(e)
        return package

    def path_from_url(self, url, replacement):
        parsed = urlparse(url)
        root = parsed.netloc if not ':' in parsed.netloc else parsed.netloc.replace(':', '_')
        if parsed.path:
            subpath = parsed.path
            if os.sep in subpath:
                subpath = subpath.replace(os.sep, '')
            return os.path.join(root, subpath.replace('.', replacement))
        else:
            return root