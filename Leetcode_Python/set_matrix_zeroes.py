class Solution:
    # @param matrix, a list of lists of integers
    # RETURN NOTHING, MODIFY matrix IN PLACE.
    def setZeroes(self, matrix):
        m = len(matrix)
        n = len(matrix[0])
        row = []
        col = []
        for i in xrange(m):
            for j in xrange(n):
                if matrix[i][j] == 0:
                    if i not in row: row.append(i)
                    if j not in col: col.append(j)
        for r in row:
            matrix[r] = [0] * n
        for c in col:
            for s in matrix:
                s[c] = 0
