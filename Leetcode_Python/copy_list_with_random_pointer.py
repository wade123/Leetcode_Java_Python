# Definition for singly-linked list with a random pointer.
# class RandomListNode:
#     def __init__(self, x):
#         self.label = x
#         self.next = None
#         self.random = None

class Solution:
    # @param head, a RandomListNode
    # @return a RandomListNode
    def copyRandomList(self, head):
        if not head:
            return None
        chead = RandomListNode(head.label)
        d = {head: chead}
        p = chead
        node = head.next
        while node:
            tem = RandomListNode(node.label)
            d[node] = tem
            p.next = tem
            p = tem
            node = node.next
        
        d[None] = None
        node = head
        q = chead
        while node:
            q.random = d[node.random]
            node = node.next
            q = q.next
       
        return chead
