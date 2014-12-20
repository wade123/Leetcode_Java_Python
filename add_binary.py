'''Version 1'''
class Solution:
    # @param a, a string
    # @param b, a string
    # @return a string
    def addBinary(self, a, b):
        a = a[::-1]
        b = b[::-1]
        i = j =carry = 0
        Sum = []
        while i < len(a) and j < len(b):
            Sum.append( carry ^ int(a[i]) ^ int(b[j]) )
            if int(a[i]) + int(b[j]) + carry >= 2:
                carry = 1
            else:
                carry = 0
            i, j = i+1, j+1
        while i < len(a):
            Sum.append( carry ^ int(a[i]) )
            if int(a[i]) + carry >= 2: carry = 1
            else: carry = 0
            i += 1
        while j < len(b):
            Sum.append( carry ^ int(b[j]) )
            if int(b[j]) + carry >= 2: carry = 1
            else: carry = 0
            j += 1
        if carry == 1:
            Sum.append(1)
        out = ''.join([str(i) for i in Sum])
        out = out[::-1]
        return out

'''Version 2'''
class Solution:
    # @param a, a string
    # @param b, a string
    # @return a string
    def addBinary(self, a, b):
        a = int(a, 2)
        b = int(b, 2)
        c = a + b
        return bin(c)[2:]
