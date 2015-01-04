'''Version 1'''
class Solution:
    # @return an integer
    def uniquePaths(self, m, n):
        res = [[1] * n] * m
        for i in xrange(1, m):
            for j in xrange(1, n):
                res[i][j] = res[i - 1][j] + res[i][j - 1]
        return res[m - 1][n - 1]

'''Version''' #Time Limit Exceeded, Last executed input:23, 12
class Solution:
    def uniquePaths(self, m, n):
        if m == 1 or n == 1: return 1
        return self.uniquePaths(m - 1, n) + self.uniquePaths(m, n - 1)
