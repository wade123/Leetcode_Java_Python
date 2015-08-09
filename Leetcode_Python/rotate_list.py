# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    # @param head, a ListNode
    # @param k, an integer
    # @return a ListNode
    def rotateRight(self, head, k):
        if not head or head.next == None or k == 0:
            return head
        length = 1
        count = head
        while count.next:
            count = count.next
            length += 1
        step = length - k % length
        dummy = ListNode(-1)
        dummy.next = head
        p = dummy
        for i in xrange(step):
            p = p.next
        count.next = head
        dummy.next = p.next
        p.next = None
        return dummy.next
