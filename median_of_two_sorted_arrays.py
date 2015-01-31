'''Version 1: O(log(m + n))'''
class Solution:
    # @return a float
    def findMedianSortedArrays(self, A, B):
        length = len(A) + len(B)
        if length % 2 == 1:
            return self.findKth(A, B, length / 2 + 1)
        else:
            return (self.findKth(A, B, length / 2) + self.findKth(A, B, length / 2 + 1)) / 2.0
        
    def findKth(self, A, B, k):
        if len(A) > len(B):
            return self.findKth(B, A, k)
        else:
            if len(A) == 0:
                return B[k - 1]
            if k == 1:
                return min(A[0], B[0])
            else:
                pa = min(k / 2, len(A))
                pb = k - pa
                if A[pa - 1] <= B[pb - 1]:
                    return self.findKth(A[pa:], B, k - pa)
                else:
                    return self.findKth(A, B[pb:], k - pb)

'''Version 2: O(m + n)'''
class Solution:
    # @return a float
    def findMedianSortedArrays(self, A, B):
        if not A:
            return B[len(B)/2] if len(B) % 2 == 1 else (B[len(B) / 2 - 1] + B[len(B) / 2]) / 2.0
        if not B:
            return A[len(A)/2] if len(A) % 2 == 1 else (A[len(A) / 2 - 1] + A[len(A) / 2]) / 2.0
        i = j = 0
        C = []
        while i < len(A) and j < len(B):
            if A[i] < B[j]:
                C.append(A[i])
                i += 1
            else:
                C.append(B[j])
                j += 1
        while i < len(A):
            C.append(A[i])
            i += 1
        while j < len(B):
            C.append(B[j])
            j += 1
        k = len(C)
        return C[k/2] if k % 2 == 1 else (C[k / 2 - 1] + C[k / 2]) / 2.0
        

                
