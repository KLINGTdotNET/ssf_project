import argparse
from urllib.parse import urlparse
from urllib.request import Request, urlopen
from urllib.error import HTTPError
from os.path import isdir, exists

def _get_parser():
    parser = argparse.ArgumentParser(
        description='Convert a XML Schema Description to a class representation (default is Java)',
        epilog='Example: "python3 foo.py http://api.facebook.com/1.0/facebook.xsd ~/generated_lib"')
    parser.add_argument('url',
        help='The url can point to a local file or to a web resource.')
    parser.add_argument('dest',
        help='Path to the destination where the generated files will be saved.')
    parser.add_argument('-l, --lang',
        default='Java',
        help='Name of the destination language. (Note: This feature is currently not implemented!)')
    return parser

def _check_args(args):
    """
    Checks if the given arguments are valid
    """
    content = _read_url(args.url)
    args.content = content
    return content is not None and _check_dest(args.dest)

def _read_url(url):
    """
    Reads content from url depending on location (local/remote)
    """
    if urlparse(url).scheme == "":
        try:
            with open(url, 'r', encoding='UTF-8') as f:
                return f.read()
        except FileNotFoundError as e:
            print(e)
            return None
    else:
        request = Request(url, headers={"Content-Type":"text/plain;charset=utf-8"})
        try:
            with urlopen(request) as f:
                return f.read().decode(encoding='UTF-8')
        except HTTPError as e:
            print(e)
            return None

def _check_dest(path):
    """
    Checks if the destination directory exists. Returns True if it exists, False otherwise.
    """
    try:
        if isdir(path):
            return True
        else:
            print('"{}" is not a directory or doesn\'t exist!'.format(path))
    except Exception as e:
        print(e)
    return False

def get_args():
    """
    Returns the parsed arguments from the CLI.
    """
    parser = _get_parser()
    args = parser.parse_args()
    if _check_args(args):
        args
        return args
    else:
        print("Something went wrong :(")
