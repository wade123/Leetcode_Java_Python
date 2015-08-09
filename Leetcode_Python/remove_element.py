class Solution:
    # @param    A       a list of integers
    # @param    elem    an integer, value need to be removed
    # @return an integer
    def removeElement(self, A, elem):
        i = j = 0
        while i < len(A):
            if A[i] == elem: 
                i += 1
            else: 
                A[j] = A[i]
                i, j = i+1 , j+1
        return j
