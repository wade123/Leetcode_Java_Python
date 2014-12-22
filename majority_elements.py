class Solution:
    # @param num, a list of integers
    # @return an integer
    def majorityElement(self, num):
        if len(num) <= 2:   return num[0]
        d = {}
        for i in num:
            if i not in d.keys():
                d[i] = 1
            else:
                d[i] += 1
        ma = max( d.values() )
        for j in d.keys():
            if d[j] == ma:
                return j
