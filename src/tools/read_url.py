from urllib.parse import urlparse
from urllib.request import Request, urlopen
from urllib.error import HTTPError

def read(url):
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