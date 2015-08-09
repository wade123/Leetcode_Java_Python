# Definition for a  binary tree node
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    # @return a list of tree node
    def generateTrees(self, n):
        return self.dp(1, n)
        
    def dp(self, left, right):
        if left > right:
            return [None]
        else:
            res = []
            for i in xrange(left, right + 1):
                for j in self.dp(left, i - 1):
                    for k in self.dp(i + 1, right):
                        node = TreeNode(i)
                        node.left = j
                        node.right = k
                        res.append(node)
            return res
