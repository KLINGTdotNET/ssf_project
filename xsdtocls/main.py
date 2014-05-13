#!/usr/bin/env python3

from tools import cli
from processor import parser, mapper
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
        mapper.map(tree)

if __name__ == '__main__':
    main()
