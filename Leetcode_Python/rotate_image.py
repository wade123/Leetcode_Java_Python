class Solution:
    # @param matrix, a list of lists of integers
    # @return a list of lists of integers
    def rotate(self, matrix):
        n = len(matrix)
        for k in xrange(0, n/2):
            for i in xrange(k, n-1-k):
                matrix[i][n-1-k], matrix[n-1-k][n-1-i], matrix[n-1-i][k], matrix[k][i] =\
                matrix[k][i], matrix[i][n-1-k], matrix[n-1-k][n-1-i], matrix[n-1-i][k]
        return matrix
