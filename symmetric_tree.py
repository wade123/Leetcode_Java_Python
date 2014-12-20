# Definition for a  binary tree node
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    # @param root, a tree node
    # @return a boolean
    def isSymmetric(self, root):
        if root == None:
            return True
        else:
            return self.isSym(root.left, root.right)
        
    def isSym(self, r1, r2):
        if r1 == r2 == None:
            return True
        elif r1 == None or r2 == None:
            return False
        elif r1.val != r2.val:
            return False
        else:
            return self.isSym(r1.left, r2.right) and self.isSym(r1.right, r2.left)
