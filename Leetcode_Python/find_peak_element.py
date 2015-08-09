'''Version 1: Binary Search O(logN)'''
class Solution:
    # @param num, a list of integer
    # @return an integer
    def findPeakElement(self, num):
        left = 0; right = len(num) - 1
        while left <= right:
            if left == right:
                return left
            mid = (left + right) / 2
            if num[mid] > num[mid + 1]:
                right = mid
            else:
                left = mid + 1

'''Version 2: Brute-Force O(n)'''
class Solution:
    def findPeakElement(self, num):
        if len(num) == 1:   return 0
        if num[-1] > num[-2]:   return len(num) - 1
        i = 0
        while i <= len(num) - 2:
            if num[i] < num[i + 1]:
                i += 1
            else:
                return i

