class Solution:
    # @param s, a string
    # @return an integer
    def titleToNumber(self, s):
        def value(ch):
            return ord(ch) - ord('A') + 1
        s = list(s[::-1])
        s1 = map(value, s)
        for i in xrange(len(s1)):
            s1[i] = s1[i] * (26 ** i)
        return sum(s1)
