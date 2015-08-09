class Solution:
    # @param board, a 9x9 2D array
    # @return a boolean
    def isValidSudoku(self, board):
        for i in board:
            dup = []
            for j in i:
                if j != '.':
                    if j not in dup:
                        dup.append(j)
                    else:
                        return False
        
        for i in xrange(9):
            dup = []
            for j in xrange(9):
                t = board[j][i]
                if t != '.':
                    if t not in dup:
                        dup.append(t)
                    else:
                        return False
        
        for i in [0, 3, 6]:
            for j in [0, 3, 6]:
                dup = []
                for m in xrange(3):
                    for n in xrange(3):
                        ele = board[i+m][j+n]
                        if ele != '.':
                            if ele not in dup:
                                dup.append(ele)
                            else:
                                return False
        return True
