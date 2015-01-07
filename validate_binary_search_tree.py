# Definition for a  binary tree node
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    # @param root, a tree node
    # @return a boolean
    def isValidBST(self, root):
        if root == None: return True
        lis = self.inOrder(root, [])
        if len(lis) <= 1:  return True
        for i in xrange(len(lis) - 1):
            if lis[i] >= lis[i + 1]:
                return False
        return True

    def inOrder(self, node, re):
        if node == None:  return
        if node.left:
            self.inOrder(node.left, re)
        re.append(node.val)
        if node.right:
            self.inOrder(node.right, re)
        return re
