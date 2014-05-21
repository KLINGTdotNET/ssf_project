#!/usr/bin/env python3

from tools import cli
from processor import parser, mapper
from generator import renderer
import logging

import pprint
pp = pprint.PrettyPrinter(indent=4)

def main():
    args = cli.get_args()
    log_format = '[%(levelname)s] (#%(lineno)s) %(filename)s->%(funcName)s>>> "%(message)s"'
    if args.debug:
        logging.basicConfig(format=log_format, level=logging.DEBUG)
    else:
        logging.basicConfig(format=log_format)
    tree = parser.parse(args.url)
    if tree:
        model = mapper.map(tree)
        pp.pprint(model['types'])
        renderer.render(model, args.dest, args.lang)

if __name__ == '__main__':
    main()
