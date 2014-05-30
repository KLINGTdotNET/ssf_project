import logging
import os

from generator import javaRenderer

def render(model, path, lang, overwrite):
    '''
    This method delegates the model input to the specific render corresponding to the *lang* argument

    Args:
        model (dict): Output of classmappers map function
        path (str): A path that points to the destination where the generated class files should be stored
        lang (str): The name of the Language that should be generated
        overwrite (bool): If True then the existing output will be overwritten, otherwise not
    '''
    if lang.lower() == 'java':
        renderer = javaRenderer.Renderer(os.path.join('xsdtocls', 'templates', lang.lower()))
        renderer.render(model, path, overwrite)