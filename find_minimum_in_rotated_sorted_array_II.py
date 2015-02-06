class Solution:
    # @param num, a list of integer
    # @return an integer
    def findMin(self, num):
        left = 0
        right = len(num) - 1
        Min = num[0]
        while left + 2 <= right:
            mid = (left + right) / 2
            if num[mid] > num[left]:
                left = mid + 1
            elif num[mid] < num[left]:
                right = mid - 1
            else:
                left += 1
            Min = min(num[left], Min, num[right], num[mid])
        Min = min(num[left], Min, num[right])
        return Min
