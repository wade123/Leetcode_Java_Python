class Solution:
    # @param s, a string
    # @param dict, a set of string
    # @return a list of strings
    def wordBreak(self, s, dict):
        res = []
        self.dfs(s, dict, '', res)
        return res
        
    def dpCheck(self, s, dict):
        if s == '':
            return True
        res = [False for i in xrange(len(s) + 1)]
        res[0] = True
        for i in xrange(len(s)):
            for j in xrange(i + 1):
                if res[j] and (s[j:i + 1] in dict):
                    res[i + 1] = True
                    break
        return res[len(s)]
        
    def dfs(self, s, dict, lst, res):
        if self.dpCheck(s, dict):
            if len(s) == 0:
                res.append(lst[:-1])
            for i in xrange(len(s)):
                if s[:i + 1] in dict:
                    self.dfs(s[i + 1:], dict, lst + s[:i + 1] + ' ', res)
