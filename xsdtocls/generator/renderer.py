import logging
import os

from generator import javaRenderer

def render(model, path, lang):
    if lang.lower() == 'java':
        renderer = javaRenderer.Renderer(os.path.join('xsdtocls', 'templates', lang.lower()))
        renderer.render(model, path)