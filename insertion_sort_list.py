# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    # @param head, a ListNode
    # @return a ListNode
    def insertionSortList(self, head):
        if not head or head.next == None:  
            return head
        dummy = ListNode(-1)
        dummy.next = head
        p = head
        while p.next:
            if p.val < p.next.val:
                p = p.next
            else:
                q = dummy
                while q.next.val < p.next.val:
                    q = q.next
                tem = q.next
                q.next = p.next
                p.next = p.next.next
                q.next.next = tem
        return dummy.next
        
