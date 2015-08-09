class Solution:
    # @return a string
    def convert(self, s, nRows):
        if nRows == 1: return s
        re = [ [] for i in xrange(nRows) ]  # re = [[]]*nRows
        i = 0
        j = 0
        while i < len(s):
            if j == 0:
                while j <= nRows - 1 and i < len(s):
                    re[j].append(s[i])
                    i += 1
                    j += 1
            if j == nRows:
                j = j - 2
                while j >= 1 and i < len(s):
                    re[j].append(s[i])
                    i += 1
                    j -= 1
        return ''.join( [''.join(i) for i in re] )
