import unittest

from lesson1 import binary_gap


class TestBinaryGap(unittest.TestCase):
    def test_solution(self):
        self.assertEqual(0, binary_gap.solution(1))
        self.assertEqual(0, binary_gap.solution(15))
        self.assertEqual(1, binary_gap.solution(20))
        self.assertEqual(2, binary_gap.solution(9))
        self.assertEqual(4, binary_gap.solution(529))
        self.assertEqual(5, binary_gap.solution(1041))
