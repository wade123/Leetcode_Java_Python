# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    # @param head, a ListNode
    # @return a ListNode
    def deleteDuplicates(self, head):
        if head == None:
            return None
        if head.next == None:
            return head
        dummy = ListNode(0)
        dummy.next = head
        t = dummy
        s = dummy.next
        while t.next:
            while s.next and t.next.val == s.next.val:
                s = s.next
            if s == t.next:
                s = s.next
                t = t.next
            else:
                t.next = s.next
        return dummy.next
