#!/usr/bin/env python3

from tools import cli, read_url

def main():
    args = cli.get_args()
    content = read_url.read(args.url)
    print(content)

if __name__ == '__main__':
    main()
