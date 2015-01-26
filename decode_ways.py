class Solution:
    # @param s, a string
    # @return an integer
    def numDecodings(self, s):
        if not s or s[0] == '0':
            return 0
        dp = [0 for i in xrange(len(s) + 1)]
        dp[0] = 1
        dp[1] = 1
        for i in xrange(2, len(s) + 1):
            if 1 <= int(s[i - 1]) <= 9:
                dp[i] += dp[i - 1]
            if 10 <= int(s[i - 2] + s[i - 1]) <= 26:
                dp[i] += dp[i - 2]
        return dp[-1]
