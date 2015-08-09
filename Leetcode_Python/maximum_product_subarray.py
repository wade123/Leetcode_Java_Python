class Solution:
    # @param A, a list of integers
    # @return an integer
    def maxProduct(self, A):
            Max = Min = re = A[0]
            for i in xrange(1, len(A)):
                temp_Max = Max
                Max = max(Max * A[i], Min * A[i], A[i])
                Min = min(temp_Max * A[i], Min * A[i], A[i])
                re = max(re, Max)
            return re
