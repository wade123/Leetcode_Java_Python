class Solution:
    # @param prices, a list of integer
    # @return an integer
    def maxProfit(self, prices):
        length = len(prices)
        if length == 0 or length == 1:
            return 0
        
        Min = prices[0]
        maxPro1 = 0
        maxleft = []
        for i in xrange(length):
            Min = min(Min, prices[i])
            maxPro1 = max(maxPro1, prices[i] - Min)
            maxleft.append(maxPro1)
        
        Max = prices[length - 1]
        maxPro2 = 0
        maxright = [0 for i in xrange(length)]
        for j in xrange(length - 1, -1, -1):
            Max = max(Max, prices[j])
            maxPro2 = max(maxPro2, Max - prices[j])
            maxright[j] = maxPro2
            
        maxProAll = 0
        for i in xrange(length):
            maxProAll = max(maxProAll, maxleft[i] + maxright[i])
        return maxProAll
