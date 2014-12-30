class Solution:
    # @return an integer
    def trailingZeroes(self, n):
        res = 0
        while n >= 5:
            res += n/5
            n /= 5
        return res
