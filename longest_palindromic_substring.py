class Solution:
    # @return a string
    def longestPalindrome(self, s):
        if len(s) <= 1:  return s
        
        Max = ''
        for i in xrange(len(s) - 1):
            j = i + 1
            p = 0
            while i - p >=0 and j + p < len(s) and s[i - p] == s[j + p]:
                p += 1
            if 2 * p > len(Max):
                Max = s[i - p + 1: j + p]
        
        Max2 = ''      
        for i in xrange(len(s) - 1):
            p = 0
            while i - p >=0 and i + p < len(s) and s[i - p] == s[i + p]:
                p += 1
            if 2 * p - 1 > len(Max2):
                Max2 = s[i - p + 1: i + p]
        
        return Max if len(Max) > len(Max2) else Max2
                
