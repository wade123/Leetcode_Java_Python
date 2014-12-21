class Solution:
    # @return a list of lists of integers
    def generate(self, numRows):
        res = [ [1]*i for i in xrange(1, numRows + 1) ]
        for i in xrange(2, numRows):
            for j in xrange(1, i):
                res[i][j] = res[i-1][j-1] + res[i-1][j]
        return res
