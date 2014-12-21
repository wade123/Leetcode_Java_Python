# Definition for a  binary tree node
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    # @param root, a tree node
    # @param sum, an integer
    # @return a list of lists of integers
    def pathSum(self, root, sum):
        def dfs(node, path, csum):
            if node.left == None and node.right == None:
                if csum == sum:
                    res.append(path)
            if node.left != None:
                dfs(node.left, path + [node.left.val], csum + node.left.val)
            if node.right != None:
                dfs(node.right, path + [node.right.val], csum + node.right.val)
        
        if root == None:    
            return []
        res = []
        dfs(root, [root.val], root.val)
        return res
