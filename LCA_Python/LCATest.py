# Imogen Green
# Student number: 17326096
# CSU33012 coursework MT 2021/22

import unittest
from LCA import *


class MyTestCase(unittest.TestCase):

    # A basic test case which test a tree that looks like:
    #          1
    #        /   \
    #      2       3
    # The lowest common ancestor of 2 and 3 must be 1, the root node.
    def test_lca_exists1(self):
        root_node = Node(1)
        root_node.left = Node(2)
        root_node.right = Node(3)
        self.assertEqual(1, find_lca(root_node, 2, 3))

    # We are building a tree to test on that looks like this:
    #            ____ 1_____
    #           /           \
    #         2               3
    #       /     \        /     \
    #      4       5      6        7
    #     / \    /  \    /  \     /   \
    #    8   9  10   11 12  13   14   15
    # We look for the LCA of 4 and 11, and compare it to 2, which should be its LCA

    def test_lca_exists2(self):
        root_node = Node(1)
        root_node.left = Node(2)
        root_node.right = Node(3)
        root_node.left.left = Node(4)
        root_node.left.right = Node(5)
        root_node.right.left = Node(6)
        root_node.right.right = Node(7)
        root_node.left.left.left = Node(8)
        root_node.left.left.right = Node(9)
        root_node.left.right.left = Node(10)
        root_node.left.right.right = Node(11)
        root_node.right.left.left = Node(12)
        root_node.right.left.right = Node(13)
        root_node.right.right.left = Node(14)
        root_node.right.right.right = Node(15)
        self.assertEqual(2, find_lca(root_node, 4, 11))

    # Testing for when there is no root node
    def test_no_root_exists(self):
        self.assertEqual(None, find_lca(None, 2, 3))


if __name__ == '__main__':
    unittest.main()
