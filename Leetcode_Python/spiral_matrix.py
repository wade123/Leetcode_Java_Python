class Solution:
    # @param matrix, a list of lists of integers
    # @return a list of integers
    def spiralOrder(self, matrix):
        if not matrix:
            return []
        m = len(matrix)
        n = len( matrix[0] )
        re = []
        a = b = 0
        while m >1 and n>1 and n-1>b and m-1>a:
            for i in xrange(b,n-1):
                re.append(matrix[a][i])
            for j in xrange(a,m-1):
                re.append(matrix[j][n-1])
            for k in xrange(n-1,b,-1):
                re.append(matrix[m-1][k])
            for s in xrange(m-1,a,-1):
                re.append(matrix[s][b])
            m,n = m-1, n-1
            a,b = a+1, b+1
        if n - b > 1 and m - a == 1:
            for x in xrange(b,n):
                re.append(matrix[a][x])
        if m - a > 1 and n - b == 1:
            for y in xrange(a,m):
                re.append(matrix[y][b])
        if m - a == 1 and n - b == 1:
            re.append(matrix[a][b])
        return re
