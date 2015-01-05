# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    # @param head, a ListNode
    # @param x, an integer
    # @return a ListNode
    def partition(self, head, x):
        if head == None or head.next == None:  return head
        dummy = ListNode(-1)
        dummy.next = head
        end = dummy
        length = 0
        while end.next:
            end = end.next
            length += 1
        p = dummy
        i = 0
        while i < length:
            q = p.next
            if q.val >= x:
                end.next = q
                p.next = q.next
                end = end.next
                end.next = None
            else:
                p = p.next
            i += 1
        return dummy.next
