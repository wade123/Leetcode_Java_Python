'''Version 1'''
class Solution:
    # @param obstacleGrid, a list of lists of integers
    # @return an integer
    def uniquePathsWithObstacles(self, obstacleGrid):
        m = len(obstacleGrid)
        n = len(obstacleGrid[0])
        res = [[0 for i in xrange(n)] for j in xrange(m)] # res = [[0] * n] * m do not work, I don't know why, welcome discuss!
        for i in xrange(n):
            if obstacleGrid[0][i] == 0:  res[0][i] = 1
            else:  break
        for j in xrange(m):
            if obstacleGrid[j][0] == 0:  res[j][0] = 1
            else:  break
        for i in xrange(1, m):
            for j in xrange(1, n):
                res[i][j] = res[i - 1][j] + res[i][j - 1] if obstacleGrid[i][j] == 0 else 0
        return res[m - 1][n - 1]

'''Version 2: reuse the code from unique paths'''#Time Limit Exceeded bu can yeild right answers
class Solution:
    def uniquePathsWithObstacles(self, obstacleGrid):
        m = len(obstacleGrid)
        n = len(obstacleGrid[0])
        obsIndex = []
        for i in xrange(m):
            for j in xrange(n):
                if obstacleGrid[i][j] == 1:
                    obsIndex.append([i, j])
        if ([m - 1, n - 1] in obsIndex) or ([0, 0] in obsIndex):
            return 0
        else:
            res = self.uniquePaths(m, n)
            for [s, t] in obsIndex:
                res -= self.uniquePaths(s + 1, t + 1) * self.uniquePaths(m - s, n - t)
            return res
            
    def uniquePaths(self, m, n):
        res = [[1] * n] * m
        for i in xrange(1, m):
            for j in xrange(1, n):
                res[i][j] = res[i - 1][j] + res[i][j - 1]
        return res[m - 1][n - 1]

        
        
