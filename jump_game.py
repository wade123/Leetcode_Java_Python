class Solution:
    # @param A, a list of integers
    # @return a boolean
    def canJump(self, A):
        if len(A) == 1:  return True
        reach = 0
        i = 0
        while i <= reach and i < len(A):
            reach = max(A[i] + i, reach)
            i += 1
        if i < len(A):
            return False
        return True
        
            
        
        
