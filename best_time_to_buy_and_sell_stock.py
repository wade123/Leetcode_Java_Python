class Solution:
    # @param prices, a list of integer
    # @return an integer
    def maxProfit(self, prices):
        if not prices:  return 0
        Min = prices[0]
        maxProfit = 0
        for i in xrange(len(prices)):
            Min = min(Min, prices[i])
            maxProfit = max(maxProfit, prices[i] - Min)
        return maxProfit
