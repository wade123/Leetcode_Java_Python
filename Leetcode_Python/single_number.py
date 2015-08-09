'''Version 1: Bit Manipulation'''
class Solution:
    # @param A, a list of integer
    # @return an integer
    def singleNumber(self, A):
        return reduce(lambda x, y : x ^ y, A)

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

'''Version 3'''
class Solution:
    def singleNumber(self, A):
        return 2 * sum(set(A)) - sum(A)
