class Solution:
    # @param A a list of integers
    # @return an integer
    def removeDuplicates(self, A):
        if len(A) <= 1: return len(A)
        j = 0
        cnt = 1
        for i in xrange(1, len(A)):
            if A[i] == A[j]:
                cnt += 1
                if cnt >= 3:
                    continue
                else:
                    j += 1
                    A[j] = A[i]
            else:
                j += 1
                A[j] = A[i]
                cnt = 1
        return j + 1
