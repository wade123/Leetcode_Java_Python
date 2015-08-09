class Solution:
    # @return a string
    def longestCommonPrefix(self, strs):
        if len(strs) == 0 or ('' in strs):  return ''
        if len(strs) == 1:  return strs[0]
        strs = [list(i) for i in strs]
        out = reduce(self.longest, strs)
        return ''.join(out)
    
    def longest(self, a, b):
        i = 0; c = []
        while i < len(a) and i < len(b):
            if a[i] == b[i]:
                c.append(a[i])
            else:   break
            i += 1
        return c
