public class GameOfLife {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                changeStatus(board, i, j);
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 2) {
                    board[i][j] = 1;
                } else if (board[i][j] == 3) {
                    board[i][j] = 0;
                }
            }
        }
    }

    private void changeStatus(int[][] board, int i, int j) {
        int count = 0;
        for (int m = i - 1; m <= i + 1; m++) {
            for (int n = j - 1; n <= j + 1; n++) {
                if (m == i && n == j) {
                    continue;
                } else if (valid(board, m, n) && (board[m][n] == 1 || board[m][n] == 3)) {
                    count++;
                }
            }
        }
        if (board[i][j] == 1 && (count < 2 || count > 3)) {
            board[i][j] = 3;
        } else if (board[i][j] == 0 && count == 3) {
            board[i][j] = 2;
        }
    }

    private boolean valid(int[][] board, int i, int j) {
        int m = board.length;
        int n = board[0].length;
        return i >= 0 && i < m && j >= 0 && j < n;
    }
}