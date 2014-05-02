import pytest

from tests.globals import local_filepath, remote_filepath
from xsdtocls.generator import parser

class TestParser:
    """
    Test lxml parser
    """
    bad_local_filepath = 'this/file/should/\\not\\be/access.ible'
    bad_remote_filepath = 'http://klingt.net/there/is/not/such/an.xsd'

    def test_local(self):
        assert parser.parse(local_filepath) is not None

    def test_remote(self):
        assert parser.parse(remote_filepath) is not None

    def test_bad_local(self):
        assert parser.parse(self.bad_local_filepath) is None

    def test_bad_remote(self):
        assert parser.parse(self.bad_remote_filepath) is None
