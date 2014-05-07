#!/usr/bin/env python3

from tools import cli
from processor import parser, extractor

def main():
    args = cli.get_args()
    tree = parser.parse(args.url)
    if tree:
        extractor.extract(tree)

if __name__ == '__main__':
    main()
