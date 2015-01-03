# Definition for a  binary tree node
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
#
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    # @param head, a list node
    # @return a tree node
    def sortedListToBST(self, head):
        if head == None: return None
        num = []
        while head:
            num.append(head.val)
            head = head.next
            
        def dfs(start,end):
            if start > end: return None
            mid = (start + end) / 2
            root = TreeNode(num[mid])
            root.left = dfs(start,mid-1)
            root.right = dfs(mid+1,end)
            return root
        
        return dfs(0,len(num)-1)
