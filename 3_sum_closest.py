class Solution:
    # @return an integer
    def threeSumClosest(self, num, target):
        length = len(num)
        if length < 3:  return None
        num.sort()
        diff = float('inf')
        res = 0
        for i in xrange(length - 2):
            left = i + 1
            right = length - 1
            while left < right:
                Sum = num[i] + num[left] + num[right]
                if abs(target - Sum) < diff:
                    diff = abs(target - Sum)
                    res = Sum
                if Sum == target:
                    return Sum
                elif Sum > target:
                    right -= 1
                else:
                    left += 1
        return res
