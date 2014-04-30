#!/usr/bin/env python3

from tools import cli, read_url

def main():
    args = cli.get_args()
    print(read_url.read(args.url))
    pass

if __name__ == '__main__':
    main()