class Solution:
    # @param A, a list of integers
    # @param target, an integer to be searched
    # @return a list of length 2, [index1, index2]
    def searchRange(self, A, target):
        x = self.binSearch(A, 0, len(A) - 1, target)
        if x == -1: return [-1, -1]
        m = n = x
        while m >= 0 and A[m] == target: m -= 1
        while n <= len(A)-1 and A[n] == target: n += 1
        return [m + 1, n - 1]

    def binSearch(self, Array, left, right, target):
        if left > right: return -1
        mid = (left + right) / 2
        if Array[mid] == target:
            return mid 
        elif Array[mid] > target:
            return self.binSearch(Array, left, mid - 1,target)
        else:
            return self.binSearch(Array, mid + 1, right, target)
