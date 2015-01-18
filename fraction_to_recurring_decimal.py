class Solution:
    # @return a string
    def fractionToDecimal(self, numerator, denominator):
        a, b = numerator, denominator 
        if a == 0:
            return str(0)
        res = ''
        if (a > 0 and b < 0) or (a < 0 and b > 0):
            res += '-'
        a = abs(a)
        b = abs(b)
        res += str(a / b)
        if a % b == 0:
            return res
        res += '.'
        rem = (a % b) * 10
        d = {}
        while rem:	    
            add = rem / b
            res += str(add)
            if rem in d:
                return res[:d[rem]] + '(' + res[d[rem]:-1] + ')'
            d[rem] = len(res) - 1
            rem = (rem % b) * 10
        return res
