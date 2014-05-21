import os
import logging
from urllib.parse import urlparse

def render(model, path):
    # create package layout, see http://maven.apache.org/guides/introduction/introduction-to-the-standard-directory-layout.html
    full_path = os.path.join(path, path_from_url(model['tns']))
    logging.debug(full_path)

def path_from_url(url):
    parsed = urlparse(url)
    root = parsed.netloc if not ':' in parsed.netloc else parsed.netloc.replace(':', '_')
    if parsed.path:
        subpath = parsed.path
        if os.sep in subpath:
            subpath = subpath.replace(os.sep, '')
        return os.path.join(root, subpath.replace('.','_'))
    else:
        return root