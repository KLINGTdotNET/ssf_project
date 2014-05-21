import logging

from generator import javaRenderer

def render(model, path, lang):
    if lang.lower() == 'java':
        javaRenderer.render(model, path)