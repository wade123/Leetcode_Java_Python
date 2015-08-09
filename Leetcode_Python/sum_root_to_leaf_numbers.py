'''Version 1'''
# Definition for a  binary tree node
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    # @param root, a tree node
    # @return an integer
    def sumNumbers(self, root):
        if root == None:    return 0
        def dfs(node, lis, re):
            lis += str(node.val)
            if node.left == None and node.right == None:
                re.append(lis)
            if node.left:
                dfs(node.left, lis, re)
            if node.right:
                dfs(node.right, lis, re)
        result = []
        dfs(root, '', result)
        return sum( [int(i) for i in result] )

'''Version 2'''
class Solution:
    # @param root, a tree node
    # @return an integer
    def sumNumbers(self, root):
        if root == None:    return 0
        self.res = res = []
        self.dfs(root, '')
        return sum( [int(i) for i in res] )
        
    def dfs(self, node, lis):
        lis += str(node.val)
        if node.left == None and node.right == None:
            self.res.append(lis)
        if node.left:
            self.dfs(node.left, lis)
        if node.right:
            self.dfs(node.right, lis)
