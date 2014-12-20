# Definition for a  binary tree node
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    # @param root, a tree node
    # @return a boolean
    def isBalanced(self, root):
        if root == None: return True
        node = root
        while node != None:
            if abs( self.depth(node.left) - self.depth(node.right) ) > 1:
                return False
            else:
                return self.isBalanced(node.left) and self.isBalanced(node.right)
    
    def depth(self, root):
        if root == None: return 0
        else:
            return 1 + max( self.depth(root.left), self.depth(root.right) )
