# Imogen Green
# Student number: 17326096
# CSU33012 coursework MT 2021/22
# LCA solution in Python adapted from solution on GeeksForGeeks

# A binary tree node
class Node:
    # Constructor to create a new binary node
    def __init__(self, key):
        self.key = key
        self.left = None
        self.right = None


# Finds the path from root node to given root of the tree.
# Stores the path in a list path[], returns true if path
# exists otherwise false
def find_path(root_node, path, k):
    # Base Case
    if root_node is None:
        return False

    # Store this node is path vector. The node will be
    # removed if not in path from root to k
    path.append(root_node.key)

    # See if the k is same as root's key
    if root_node.key == k:
        return True

    # Check if k is found in left or right sub-tree
    if ((root_node.left is not None and find_path(root_node.left, path, k)) or
            (root_node.right is not None and find_path(root_node.right, path, k))):
        return True

    # If not present in subtree rooted with root, remove
    # root from path and return False

    path.pop()
    return False


# Returns LCA if node n1 , n2 are present in the given
# binary tre otherwise return -1
def find_lca(root_node, n1, n2):
    # To store paths to n1 and n2 from the root
    path1 = []
    path2 = []

    # Find paths from root to n1 and root to n2.
    # If either n1 or n2 is not present , return -1
    if not find_path(root_node, path1, n1) or not find_path(root_node, path2, n2):
        return None

    # Compare the paths to get the first different value
    i = 0
    while i < len(path1) and i < len(path2):
        if path1[i] != path2[i]:
            break
        i += 1
    return path1[i - 1]
