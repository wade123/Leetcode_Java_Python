class Solution:
    # @return an integer
    def divide(self, dividend, divisor):
        MAX_INT = 2**31 - 1
        sign = 1 if (dividend > 0 and divisor > 0) or (dividend < 0 and divisor < 0) else -1
        m = abs(dividend)
        n = abs(divisor)
        res = 0
        while m >= n:
            k = 0
            tem = n
            while m >= tem:
                res += 1 << k
                m -= tem
                tem <<= 1
                k += 1
        res = res if sign == 1 else 0 - res
        return MAX_INT if res > MAX_INT else res
