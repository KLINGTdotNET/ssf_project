import pytest

from tests.globals import local_filepath, remote_filepath
from xsdtocls.tools import cli

class TestCLI:
    """
    Tests for the command line interface (CLI).

    Pytest can create a per test temp directory with the fixture tmpdir.
    """
    bad_dest_path = '/this/folder/should/not\\be\\there/and/is/also/a.file'

    def test_local(self, tmpdir):
        argv = [local_filepath, tmpdir.strpath]
        assert cli.get_args(argv) is not None

    def test_remote(self, tmpdir):
        argv = [remote_filepath, tmpdir.strpath]
        assert cli.get_args(argv) is not None

    def test_dest_check(self):
        argv = [local_filepath, self.bad_dest_path]
        assert cli._check_dest(self.bad_dest_path) is False
        assert cli.get_args(argv) is None
