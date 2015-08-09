class Solution:
    # @return a list of integers
    def getRow(self, rowIndex):
        res = []
        t = 1
        for i in xrange(rowIndex+1):
            res.append(t)
            t = (rowIndex - i)*t/(i + 1)
        return res
