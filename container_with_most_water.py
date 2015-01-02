class Solution:
    # @return an integer
    def maxArea(self, height):
        n = len(height)
        Max = 0
        left, right = 0, n - 1
        while left < right:
            water = (right - left) * min(height[left], height[right])
            Max = max(Max, water)
            if height[left] < height[right]:
                left += 1
            else:
                right -= 1
        return Max
