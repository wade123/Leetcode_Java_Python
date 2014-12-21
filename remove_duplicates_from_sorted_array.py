'''Version 1'''
class Solution:
    # @param a list of integers
    # @return an integer
    def removeDuplicates(self, A):
        if len(A) <= 1: return len(A)
        j = 0
        for i in xrange(len(A)):
            if A[i] == A[j]:
                continue
            else:
                j += 1
                A[j] = A[i]  #note that i must be increased before assignment
        return j + 1

'''Version 2'''
class Solution:
    # @param a list of integers
    # @return an integer
    def removeDuplicates(self, A):
        A = list(set(A))
        return len(A)
        
