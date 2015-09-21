public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        if (board.length != 9 || board[0].length != 9) {
            return false;
        }
        for (int i = 0; i < 9; i++) {
            if (!checkRow(board, i)) {
                return false;
            }
        }
        for (int i = 0; i < 9; i++) {
            if (!checkColumn(board, i)) {
                return false;
            }
        }
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                if (!checkSubmatrix(board, i, j)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean checkRow(char[][] board, int row) {
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == '.') {
                continue;
            } else if (board[row][i] < '1' || board[row][i] > '9') {
                return false;
            } else if (set.contains(board[row][i])) {
                return false;
            } else {
                set.add(board[row][i]);
            }
        }
        return true;
    }

    private boolean checkColumn(char[][] board, int column) {
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            if (board[i][column] == '.') {
                continue;
            } else if (board[i][column] < '1' || board[i][column] > '9') {
                return false;               
            } else if (set.contains(board[i][column])) {
                return false;               
            } else {
                set.add(board[i][column]);
            }
        }
        return true;
    }

    private boolean checkSubmatrix(char[][] board, int x, int y) {
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                char chr = board[x + i][y + j];
                if (chr == '.') {
                    continue;
                } else if (chr < '1' || chr > '9') {
                    return false;
                } else if (set.contains(chr)) {
                    return false;
                } else {
                    set.add(chr);
                }
            }
        }
        return true;
    }
}