import unittest

from lesson2 import cyclic_rotation


class TestCyclicRotation(unittest.TestCase):

    def test_solution(self):
        self.assertEqual([2, 1, 9, 36, 44], cyclic_rotation.solution([1, 9, 36, 44, 2], 1))
        self.assertEqual([44, 2, 1, 9, 36], cyclic_rotation.solution([1, 9, 36, 44, 2], 2))
        self.assertEqual([9, 7, 6, 3, 8], cyclic_rotation.solution([3, 8, 9, 7, 6], 3))
        self.assertEqual([0, 0, 0], cyclic_rotation.solution([0, 0, 0], 1))
        self.assertEqual([1, 2, 3, 4], cyclic_rotation.solution([1, 2, 3, 4], 4))
        self.assertEqual([], cyclic_rotation.solution([], 1))

    def test_rotate_one(self):
        a = [1, 9, 36, 44, 2]
        self.assertEqual([2, 1, 9, 36, 44], cyclic_rotation.rotate_one(a))
        self.assertEqual([44, 2, 1, 9, 36], cyclic_rotation.rotate_one(a))
        self.assertEqual([6, 3, 8, 9, 7], cyclic_rotation.rotate_one([3, 8, 9, 7, 6]))
        self.assertEqual([0, 0, 0], cyclic_rotation.rotate_one([0, 0, 0]))
        self.assertEqual([4, 1, 2, 3], cyclic_rotation.rotate_one([1, 2, 3, 4]))

    def test_simple_solution(self):
        self.assertEqual([2, 1, 9, 36, 44], cyclic_rotation.simple_solution([1, 9, 36, 44, 2], 1))
        self.assertEqual([44, 2, 1, 9, 36], cyclic_rotation.simple_solution([1, 9, 36, 44, 2], 2))
        self.assertEqual([9, 7, 6, 3, 8], cyclic_rotation.simple_solution([3, 8, 9, 7, 6], 3))
        self.assertEqual([0, 0, 0], cyclic_rotation.simple_solution([0, 0, 0], 1))
        self.assertEqual([1, 2, 3, 4], cyclic_rotation.simple_solution([1, 2, 3, 4], 4))

    def test_swap(self):
        self.assertEqual([36, 9, 1, 44, 2], cyclic_rotation.swap([1, 9, 36, 44, 2], 0, 2))
        self.assertEqual([2, 9, 36, 44, 1], cyclic_rotation.swap([1, 9, 36, 44, 2], 0, 4))


if __name__ == '__main__':
    unittest.main()
