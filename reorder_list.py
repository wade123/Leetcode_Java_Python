# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None
'''Version 1'''
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

'''Version 2''' #Time Limit Exceeded
class Solution:
    # @param head, a ListNode
    # @return nothing
    def reorderList(self, head):
        if head == None or head.next == None or head.next.next == None:
            return
        h = head
        while h.next:
            p = h
            q = p.next
            while q.next:
                p = p.next
                q = q.next
            q.next = h.next
            h.next = q
            p.next = None
            if h.next == None or h.next.next == None:
                return
            h = h.next.next
