#!/usr/bin/env python3

from tools import cli
from processor import parser, schemamapper, classmapper
from generator import renderer
import logging

def main():
    args = cli.get_args()
    log_format = '[%(levelname)s] (#%(lineno)s) %(filename)s->%(funcName)s>>> "%(message)s"'
    if args.debug:
        logging.basicConfig(format=log_format, level=logging.DEBUG)
    else:
        logging.basicConfig(format=log_format)
    tree = parser.parse(args.url)
    if tree:
        sm = schemamapper.SchemaMapper(tree)
        schemamodel = sm.map()
        cm = classmapper.ClassMapper(schemamodel)
        classmodel = cm.map()
        renderer.render(classmodel, args.dest, args.lang)

if __name__ == '__main__':
    main()
