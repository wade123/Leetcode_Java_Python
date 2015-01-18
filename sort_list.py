# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    # @param head, a ListNode
    # @return a ListNode
    def sortList(self, head):
        if not head or not head.next:
            return head
        fast = slow = head
        while fast.next and fast.next.next:
            fast = fast.next.next
            slow = slow.next
        fast = slow.next
        slow.next = None
        left = self.sortList(head)
        right = self.sortList(fast)
        return self.merge(left, right)
    
    def merge(self, l1, l2):
        dummy = ListNode(0)
        if l1 == None: dummy.next = l2
        if l2 == None: dummy.next = l1
        t = dummy
        while l1 != None and l2 != None:
            if l1.val <= l2.val:
                t.next = l1
                l1 = l1.next
            else:
                t.next = l2
                l2 = l2.next
            t = t.next
        while l1 != None:
            t.next = l1
            t = t.next
            l1 = l1.next
        while l2 != None:
            t.next = l2
            t = t.next
            l2 = l2.next
        return dummy.next
