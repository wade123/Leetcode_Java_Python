# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    # @return a ListNode
    def addTwoNumbers(self, l1, l2):
        Sum = self.getValue(l1) + self.getValue(l2)
        s = [ListNode(int(i)) for i in list(str(Sum))[::-1]]
        if len(s) == 1: return s[0]
        for j in xrange(len(s) - 1):
            s[j].next = s[j + 1]
        return s[0]
    
    def getValue(self, l):
        if l == None:   return 0
        re = []
        while l:
            re.append(l.val)
            l = l.next
        return int(''.join([str(i) for i in re[::-1]]))
