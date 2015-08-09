class Solution:
    # @return a boolean
    def isPalindrome(self, x):
        if x < 0:   return False
        k = x
        m = 1
        while k / 10:
            k /= 10
            m *= 10
        while x > 1:
            if x / m == x % 10:
                x -= (x / m) * m
                x /= 10
                m /= 100
            else:
                return False
        return True
