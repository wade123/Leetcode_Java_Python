'''Version 1: Bit Manipulation'''
class Solution:
    # @param A, a list of integer
    # @return an integer
    def singleNumber(self, A):
        t1 = t2 = t3 = 0
        for a in A:
            t2 |= (t1 & a)
            t1 ^= a
            t3 = ~(t1 & t2)
            t1 &= t3
            t2 &= t3
        return t1

'''Version 2: Hash Table'''
class Solution:
    def singleNumber(self, A):
        d = {}
        for i in xrange(len(A)):
            if A[i] not in d:
                d[A[i]] = 1
            else:
                d[A[i]] += 1
        for k in d:
            if d[k] == 1:
                return k
