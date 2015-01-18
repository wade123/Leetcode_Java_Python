class Solution:
    # @param s, a string
    # @param dict, a set of string
    # @return a boolean
    def wordBreak(self, s, dict):
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
        
