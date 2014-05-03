#!/usr/bin/env python3

from tools import cli
from generator import parser

def main():
    args = cli.get_args()
    tree = parser.parse(args.url)
    if tree:
        root = tree.getroot()

if __name__ == '__main__':
    main()
