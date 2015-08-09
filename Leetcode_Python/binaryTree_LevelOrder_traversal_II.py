# Definition for a  binary tree node
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    # @param root, a tree node
    # @return a list of lists of integers
    def levelOrder(self, root):
        if root == None: return []
        curlel = [root]
        res = []
        while curlel != []:
            num = []
            nextlel = []
            for i in curlel:
                num.append(i.val)
                if i.left != None:
                    nextlel.append(i.left)
                if i.right != None:
                    nextlel.append(i.right)
            res.append(num)
            curlel = nextlel
        return res[::-1]
