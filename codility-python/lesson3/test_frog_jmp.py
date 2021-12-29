import unittest

from lesson3 import frog_jmp


class TestPermMissingElem(unittest.TestCase):

    def test_solution(self):
        self.assertEqual(3, frog_jmp.solution(10, 85, 30))
        self.assertEqual(0, frog_jmp.solution(1, 1, 1))
