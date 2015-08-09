class Solution:
    # @param n, an integer
    # @return an integer
    def climbStairs(self, n):
        if n == 1: return 1
        elif n == 2: return 2
        else:
            a = 1; b = 2
            for i in xrange(n-2):
                a, b = b, a + b
            return b
        
