class Solution:
    # @param num, a list of integer
    # @return an integer
    def findMin(self, num):
        left = 0
        right = len(num) - 1
        if num[left] < num[right]:
            return num[left]
        while left <= right:
            if left == right:
                return num[left]
            if left + 1 == right:
                return min(num[left], num[right])
            else:
                mid = (left + right) / 2
                if num[mid] < num[mid + 1] and num[mid] < num[mid - 1]:
                    return num[mid]
                if num[mid] > num[left]:
                    left = mid
                else:
                    right = mid - 1
