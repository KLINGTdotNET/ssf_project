#!/usr/bin/env python3

from tools import cli
from processor import parser, mapper
import logging

def main():
    args = cli.get_args()
    if args.debug:
        logging.basicConfig(level=logging.DEBUG)
    tree = parser.parse(args.url)
    if tree:
        mapper.map(tree)

if __name__ == '__main__':
    main()
