class Solution:
    # @param prices, a list of integer
    # @return an integer
    def maxProfit(self, prices):
        if len(prices) == 0 or len(prices) == 1:
            return 0
        maxProfit = 0
        for i in xrange(1, len(prices)):
            diff = prices[i] - prices[i - 1]
            maxProfit += diff if diff > 0 else 0
        return maxProfit
        
