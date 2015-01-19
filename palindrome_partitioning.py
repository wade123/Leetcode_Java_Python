class Solution:
    # @param s, a string
    # @return a list of lists of string
    def partition(self, s):
        self.length = len(s)
        res = []
        self.dfs(s, 0, [], res)
        return res
    
    def dfs(self, s, i, lst, res):
        if i == self.length:
            res.append(lst)
        for j in xrange(i + 1, len(s) + 1):
            if s[i:j] == s[i:j][::-1]:
                self.dfs(s, j, lst + [s[i:j]], res)
