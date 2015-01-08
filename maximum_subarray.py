class Solution:
    # @param A, a list of integers
    # @return an integer
    def maxSubArray(self, A):
        S = re = A[0]
        for i in xrange(1,len(A)):
            S = max(A[i], S + A[i])
            re = max(re, S)
        return re
