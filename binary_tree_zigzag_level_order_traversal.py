# Definition for a  binary tree node
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    # @param root, a tree node
    # @return a list of lists of integers
    def zigzagLevelOrder(self, root):
        if root == None: return []
        curlel = [root]
        res = []
        flag = 0
        while curlel != []:
            num = []
            nextlel = []
            if flag == 0:
                for i in curlel[::-1]:
                    num.append(i.val)
                    if i.left != None:
                        nextlel.append(i.left)
                    if i.right != None:
                        nextlel.append(i.right)
                res.append(num)
                curlel = nextlel
                flag += 1
                continue
            if flag == 1:
                for i in curlel[::-1]:
                    num.append(i.val)
                    if i.right != None:
                        nextlel.append(i.right)
                    if i.left != None:
                        nextlel.append(i.left)
                res.append(num)
                curlel = nextlel
                flag -= 1
                continue
        return res
