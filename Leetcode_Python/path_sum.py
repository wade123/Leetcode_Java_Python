# Definition for a  binary tree node
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    # @param root, a tree node
    # @param sum, an integer
    # @return a boolean
    def hasPathSum(self, root, sum):
        if root == None:    return False
        re = self.dfs(root, 0, [])
        return sum in re
        
    def dfs(self, node, s, res):
        s = s + node.val
        if node.left == None and node.right == None:
            res.append(s)
        if node.left != None:
            self.dfs(node.left, s, res)
        if node.right != None:
            self.dfs(node.right, s, res)
        return res
