# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    # @param two ListNodes
    # @return the intersected ListNode
    def getIntersectionNode(self, headA, headB):
        p = headA
        q = headB
        la = 0; lb = 0
        while p != None:
            p = p.next
            la += 1
        while q != None:
            q = q.next
            lb += 1
        p = headA
        q = headB
        if la > lb:
            t = la - lb
            while t > 0:
                p = p.next
                t -= 1
        if la < lb:
            s = lb - la
            while s > 0:
                q = q.next
                s -= 1
        while p != None and q != None:
            if p == q:
                return p
            else:
                p = p.next
                q = q.next
        return None
