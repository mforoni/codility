import unittest

from lesson3 import perm_missing_elem


class TestPermMissingElem(unittest.TestCase):

    def test_solution(self):
        self.assertEqual(1, perm_missing_elem.solution([]))
        self.assertEqual(2, perm_missing_elem.solution([1]))
        self.assertEqual(4, perm_missing_elem.solution([2, 3, 1, 5]))
        self.assertEqual(5, perm_missing_elem.solution([2, 3, 1, 4]))
