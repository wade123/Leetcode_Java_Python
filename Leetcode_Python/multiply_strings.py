'''Version 1'''
class Solution:
    # @param num1, a string
    # @param num2, a string
    # @return a string
    def multiply(self, num1, num2):
        if num1 == '0' or num2 == '0':
            return '0'
        num1 = num1[::-1]
        num2 = num2[::-1]
        m = len(num1)
        n = len(num2)
        re = [0 for i in xrange(m + n)]
        for i in xrange(m):
            for j in xrange(n):
                re[i + j] += int(num1[i]) * int(num2[j])
        carry = 0
        for i in xrange(m + n):
            re[i] += carry
            carry = re[i] / 10
            re[i] %= 10
        if re[-1] == 0:
            re.pop()
        return ''.join([str(i) for i in re])[::-1]

'''Version 2'''
class Solution:
    def multiply(self, num1, num2):
        return str(int(num1) * int(num2))
