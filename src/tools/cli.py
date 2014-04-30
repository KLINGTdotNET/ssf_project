import argparse
from urllib.parse import urlparse
from urllib.request import Request, urlopen

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
    return _check_url(args.url) and _check_dest(args.dest)

def _check_url(url):
    if urlparse(url).scheme == "":
        print("filepath")
        with open(url, 'r', encoding='UTF-8') as f:
            print(f.read())
    else:
        print("url")
        request = Request(url, headers={"Content-Type":"text/plain;charset=utf-8"})
        with urlopen(request) as f:
            print(f.read().decode(encoding='UTF-8'))
    return False

def _check_dest(url):
    return False

def get_args():
    """
    Returns the parsed arguments from the CLI.
    """
    parser = _get_parser()
    args = parser.parse_args()
    if _check_args(args):
        return args
    else:
        print("Something went wrong :(")
