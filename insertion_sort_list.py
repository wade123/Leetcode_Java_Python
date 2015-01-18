'''Version 1'''
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
        
'''Version 2'''
class Solution:
    # @param head, a ListNode
    # @return a ListNode
    def insertionSortList(self, head):
        if not head or head.next == None:  
            return head
        
        lst = []
        while head:
            lst.append(head.val)
            head = head.next
        
        for i in xrange(1, len(lst)):
            temp = lst[i]
            j = i - 1
            while j >= 0 and temp < lst[j]:
                lst[j + 1] = lst[j]
                j -= 1
            lst[j + 1] = temp
        
        res = [ListNode(i) for i in lst]
        for i in xrange(len(lst) - 1):
            res[i].next = res[i + 1]
        res[len(lst) - 1].next = None
        return res[0]
