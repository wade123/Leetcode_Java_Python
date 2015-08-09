'''Version 1: DFS recursive'''
# Definition for a undirected graph node
# class UndirectedGraphNode:
#     def __init__(self, x):
#         self.label = x
#         self.neighbors = []

class Solution:
    # @param node, a undirected graph node
    # @return a undirected graph node
    def cloneGraph(self, node):
        if not node:
            return None
        self.d = d = {}
        cnode = UndirectedGraphNode(node.label)
        d[node] = cnode
        self.dfs(node)
        return cnode
        
    def dfs(self, node):
        for i in node.neighbors:
            if i not in self.d:
                tem = UndirectedGraphNode(i.label)
                self.d[i] = tem
                self.dfs(i)
            self.d[node].neighbors.append(self.d[i])

'''Version 2: DFS iterative'''
class Solution:
    def cloneGraph(self, node):
        if not node:
            return None
        stack = []
        d = {}
        cnode = UndirectedGraphNode(node.label)
        stack.append(node)
        d[node] = cnode
        while stack:
            tnode = stack.pop()
            for ne in tnode.neighbors:
                if ne not in d:
                    cne = UndirectedGraphNode(ne.label)
                    d[ne] = cne
                    d[tnode].neighbors.append(cne)
                    stack.append(ne)
                else:
                    d[tnode].neighbors.append(d[ne])
        return cnode

'''Version 3: BFS'''
class Solution:
    def cloneGraph(self, node):
        if not node:
            return None
        queue = []
        d = {}
        cnode = UndirectedGraphNode(node.label)
        queue.append(node)
        d[node] = cnode
        while queue:
            tnode = queue.pop(0)
            lst = tnode.neighbors
            for ne in lst:
                if ne not in d:
                    cne = UndirectedGraphNode(ne.label)
                    d[ne] = cne
                    d[tnode].neighbors.append(cne)
                    queue.append(ne)
                else:
                    d[tnode].neighbors.append(d[ne])
        return cnode
