import unittest

from lesson4 import perm_check


class TestPermCheck(unittest.TestCase):

    def test_solution(self):
        self.assertEqual(1, perm_check.solution([4, 1, 3, 2]))
        self.assertEqual(0, perm_check.solution([4, 1, 3]))
        self.assertEqual(1, perm_check.solution([1]))
        self.assertEqual(0, perm_check.solution([2]))
        self.assertEqual(0, perm_check.solution([0]))
