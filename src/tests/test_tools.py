import pytest

from tools import cli, read_url
from tempfile import gettempdir

local_file = '../resources/facebook.xsd'
remote_file = 'http://api.facebook.com/1.0/facebook.xsd‎'
dest_path = gettempdir()

class TestCLI:
    bad_dest_path = '/this/folder/should/not\\be\\there/and/is/also/a.file'

    def test_local(self):
        argv = [local_file, dest_path]
        assert cli.get_args(argv) is not None

    def test_remote(self):
        argv = [remote_file, dest_path]
        assert cli.get_args(argv) is not None

    def test_dest_check(self):
        argv = [local_file, self.bad_dest_path]
        assert cli._check_dest(self.bad_dest_path) is False
        assert cli.get_args(argv) is None

class TestReadUrl:
    bad_local_file = 'this/file/should/\\not\\be/access.ible'
    bad_remote_file = 'http://klingt.net/there/is/not/such/an.xsd'

    def test_local(self):
        assert read_url.read(local_file) is not None

    def test_remote(self):
        assert read_url.read(local_file) is not None

    def test_bad_local(self):
        assert read_url.read(self.bad_local_file) is None

    def test_bad_remote(self):
        assert read_url.read(self.bad_local_file) is None
