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
        t = head
        while t.next:
            if t.val == t.next.val:
                t.next = t.next.next
            else:
                t = t.next
        return head
