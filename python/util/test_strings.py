import unittest

import util.strings as strings


class TestStrings(unittest.TestCase):

    def test_first_index_of(self):
        self.assertEqual(strings.first_index_of('1', "0103003004"), 1)
        self.assertEqual(strings.first_index_of('f', "post this text on a form"), 20)

    def test_last_index_of(self):
        self.assertEqual(strings.last_index_of('1', "01030030014"), 9)
        self.assertEqual(strings.last_index_of('f', "post this text on a form"), 20)

    def test_indexes_of(self):
        self.assertEqual(strings.indexes_of('1', "01030030014"), [1, 9])
        self.assertEqual(strings.indexes_of('f', "post this text on a fantastic form"), [20, 30])


if __name__ == '__main__':
    unittest.main()
