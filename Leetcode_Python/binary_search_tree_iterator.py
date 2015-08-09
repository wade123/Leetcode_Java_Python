# Definition for a  binary tree node
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class BSTIterator:
    # @param root, a binary search tree's root node
    def __init__(self, root):
        self.root = root
        self.smlnode = smlnode = []
        node = root
        while node:
            smlnode.append(node)
            node = node.left

    # @return a boolean, whether we have a next smallest number
    def hasNext(self):
        return True if len(self.smlnode) != 0 else False

    # @return an integer, the next smallest number
    def next(self):
        node = self.smlnode.pop()
        if node.right:
            p = node.right
            while p:
                self.smlnode.append(p)
                p = p.left
        return node.val
        
# Your BSTIterator will be called like this:
# i, v = BSTIterator(root), []
# while i.hasNext(): v.append(i.next())
