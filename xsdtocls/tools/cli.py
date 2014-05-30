import argparse
from os.path import isdir, exists

import logging

def _get_parser():
    '''
    Returns a configured ArgumentParser instance
    '''
    parser = argparse.ArgumentParser(
        description='Convert a XML Schema Description to a class representation (default is Java)',
        epilog='Example: "python3 foo.py http://api.facebook.com/1.0/facebook.xsd ~/generated_lib"')
    parser.add_argument('url',
        help='The url can point to a local file or to a web resource.')
    parser.add_argument('dest',
        help='Path to the destination where the generated files will be saved.')
    parser.add_argument('-l','--lang',
        default='Java',
        help='Name of the destination language. (Note: This feature is currently not implemented!)')
    parser.add_argument('-d','--debug',
        help='Output debugging information',
        action='store_true')
    parser.add_argument('-o', '--overwrite',
        help='If set, the generated output will be overwritten when the destination path exists',
        action='store_true')
    return parser

def _check_args(args):
    '''
    Checks if the given destination is valid

    Args:
        args (Namespace): output of the call to parse_args()
    '''
    return _check_dest(args.dest)

def _check_dest(path):
    '''
    Checks if the destination directory exists. Returns True if it exists, False otherwise.

    Args:
        path (str): destination path
    '''
    if isdir(path):
        return True
    else:
        print('"{}" is not a directory or doesn\'t exist!'.format(path))
    return False

def get_args():
    '''
    Returns the parsed command line arguments
    '''
    parser = _get_parser()
    args = parser.parse_args()
    if _check_args(args):
        return args
    else:
        logging.warn("Something is wrong with your command line arguments. :(")
