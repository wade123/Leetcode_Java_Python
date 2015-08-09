class Solution:
    # @param s, a string
    # @return a list of strings
    def restoreIpAddresses(self, s):
        length = len(s)
        if length < 4 or length > 12:
            return []
        re = []
        self.dfs(s, 0, [], re)
        return ['.'.join(k) for k in re]
            
    def dfs(self, s, index, lis, re):
        if index == 4 and len(s) == 0:
            re.append(lis)
            return
        for i in xrange(1, 4):
            if len(s) >= i and str(int(s[:i])) == s[:i] and int(s[:i]) <= 255:
                self.dfs(s[i:], index + 1, lis + [s[:i]], re)
