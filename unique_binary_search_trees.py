'''Version 1'''
class Solution:
    # @return an integer
    def numTrees(self, n):
        re = [1]
        for i in xrange(1, n + 1):
            tem = 0
            for j in xrange(i):
                tem += re[j] * re[i - 1 - j]
            re.append(tem)
        return re[n]

'''Version 2'''
class Solution:
    def numTrees(self, n):
        return 1 if n == 0 or n == 1 else sum([self.numTrees(i)*self.numTrees(n-i-1) for i in xrange(0, n)])
