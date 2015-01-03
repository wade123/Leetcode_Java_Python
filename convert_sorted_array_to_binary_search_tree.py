# Definition for a  binary tree node
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    # @param num, a list of integers
    # @return a tree node
    def sortedArrayToBST(self, num):
        def dfs(start,end):
            if start > end: return None
            mid = (start + end) / 2
            root = TreeNode(num[mid])
            root.left = dfs(start,mid-1)
            root.right = dfs(mid+1,end)
            return root
        
        return dfs(0,len(num)-1)
