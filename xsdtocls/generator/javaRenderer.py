import os
import logging
from urllib.parse import urlparse

def render(model, path):
    paths = {}
    paths['root'] = os.path.join(path, path_from_url(model['tns'], '_'))
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
        for key, value in create_project_structure(paths['root'], model['tns']).items():
            paths[key] = value
        print(paths)

def create_project_structure(root, tns):
    # create package layout, see http://maven.apache.org/guides/introduction/introduction-to-the-standard-directory-layout.html
    paths = {}
    paths['sources'] = os.path.join('src', 'main', 'java')
    sources_path = os.path.join(root, paths['sources'])
    if not os.path.isdir(sources_path):
        try:
            os.makedirs(sources_path)
        except os.error as e:
            print(e)
    paths['package'] = create_package(sources_path, tns)
    return paths

def create_package(root, tns):
    url = urlparse(tns)
    package = os.path.join(*tuple(url.netloc.split('.')[::-1]))
    full_path = os.path.join(root, package)
    if not os.path.isdir(full_path):
        try:
            os.makedirs(full_path)
        except os.error as e:
            print(e)
    return package

def path_from_url(url, replacement):
    parsed = urlparse(url)
    root = parsed.netloc if not ':' in parsed.netloc else parsed.netloc.replace(':', '_')
    if parsed.path:
        subpath = parsed.path
        if os.sep in subpath:
            subpath = subpath.replace(os.sep, '')
        return os.path.join(root, subpath.replace('.', replacement))
    else:
        return root