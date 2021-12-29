import unittest

import util.strings as strings


class TestStrings(unittest.TestCase):

    def test_first_index_of(self):
        self.assertEqual(1, strings.first_index_of('1', "0103003004"))
        self.assertEqual(20, strings.first_index_of('f', "post this text on a form"))

    def test_last_index_of(self):
        self.assertEqual(9, strings.last_index_of('1', "01030030014"))
        self.assertEqual(20, strings.last_index_of('f', "post this text on a form"))

    def test_indexes_of(self):
        self.assertEqual([1, 9], strings.indexes_of('1', "01030030014"))
        self.assertEqual([20, 30], strings.indexes_of('f', "post this text on a fantastic form"))


if __name__ == '__main__':
    unittest.main()
