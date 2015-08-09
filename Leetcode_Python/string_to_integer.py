class Solution:
    # @return an integer
    def atoi(self, str):
        str = str.strip()
        ns = []
        for i in xrange(len(str)):
            if ( str[i] in ['+', '-'] and i == 0 ) or '0' <= str[i] <= '9':
                ns.append(str[i])
            else:
                break
        if ns in [ [], ['+'], ['-'] ]:
            return 0
        out = int(''.join(ns))
        INT_MAX = 2147483647
        INT_MIN = -2147483648
        if out > INT_MAX:
            return INT_MAX
        if out < INT_MIN:
            return INT_MIN
        return out
