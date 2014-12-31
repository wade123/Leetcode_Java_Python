# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    # @param head, a ListNode
    # @return nothing
    def reorderList(self, head):
        if head == None or head.next == None or head.next.next == None:
            return
        lis = []
        p = head
        while p:
            lis.append(p)
            p = p.next
        le = len(lis)
        for i in xrange(le / 2):
            lis[i].next = lis[le - 1 - i]
            lis[le - 1 - i].next = lis[i + 1]
        lis[le / 2].next = None
