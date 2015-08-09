'''Version 1'''
class Solution:
    # @param digits, a list of integer digits
    # @return a list of integer digits
    def plusOne(self, digits):
        return [int(i) for i in list(str( int(''.join([str(i) for i in digits])) + 1 ))]

'''Version 2'''
class Solution:
    # @param digits, a list of integer digits
    # @return a list of integer digits
    def plusOne(self, digits):
        digits = digits[::-1]
        carry = 1
        for i in xrange(len(digits)):
            if digits[i] + carry <= 9:
                digits[i] += carry
                carry = 0
            else:
                digits[i] = 0
                carry = 1
        if carry == 1:
            digits.append(1)
        return digits[::-1]
