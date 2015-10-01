import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;
//bfs will do
public class SurroundedRegions {
    private Queue<Integer> queue = new LinkedList<>();

    public void solve(char[][] board) {
        if (board == null || board.length == 0
            || board[0] == null || board[0].length == 0) {
            return;
        }
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            bfs(board, i, 0);
            bfs(board, i, n - 1);
        }
        for (int j = 0; j < n; j++) {
            bfs(board, 0, j);
            bfs(board, m - 1, j);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == 'S') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void bfs(char[][] board, int i, int j) {
        fill(board, i, j);
        int n = board[0].length;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            int x = cur / n;
            int y = cur % n;
            fill(board, x + 1, y);
            fill(board, x - 1, y);
            fill(board, x, y - 1);
            fill(board, x, y + 1);
        }
    }

    private void fill(char[][] board, int i, int j) {
        if (i < 0 || i >= board.length || j < 0
            || j >= board[0].length || board[i][j] != 'O') {
            return;
        }
        board[i][j] = 'S';
        queue.offer(i * board[0].length + j);
    }

    public static void main(String[] args) {
        SurroundedRegions test = new SurroundedRegions();
        char[][] board = {{'O','X','X','O'},
                          {'X','O','O','X'},
                          {'O','X','O','X'},
                          {'X','O','X','O'}};
        test.solve(board);
        for (char[] row : board) {
            System.out.println(Arrays.toString(row));
        }
    }
}

//DFS
//This solution causes java.lang.StackOverflowError, 
//because for a large board, too many method calls 
//are pushed to the stack and causes the overflow.
class SurroundedRegions2 {
    public void solve(char[][] board) {
        if (board == null || board.length == 0
            || board[0] == null || board[0].length == 0) {
            return;
        }
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                dfs(board, i, 0);
            }
            if (board[i][n - 1] == 'O') {
                dfs(board, i, n - 1);
            }
        }
        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O') {
                dfs(board, 0, j);
            }
            if (board[m - 1][j] == 'O') {
                dfs(board, m - 1, j);
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == 'S') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int i, int j) {
        board[i][j] = 'S';
        if (valid(board, i - 1, j) && board[i - 1][j] == 'O') {
            dfs(board, i - 1, j);
        }
        if (valid(board, i + 1, j) && board[i + 1][j] == 'O') {
            dfs(board, i + 1, j);
        }
        if (valid(board, i, j - 1) && board[i][j - 1] == 'O') {
            dfs(board, i, j - 1);
        }
        if (valid(board, i, j + 1) && board[i][j + 1] == 'O') {
            dfs(board, i, j + 1);
        }

    }

    private boolean valid(char[][] board, int i, int j) {
        int m = board.length;
        int n = board[0].length;
        return i >= 0 && i < m && j >= 0 && j < n;
    }

    public static void main(String[] args) {
        SurroundedRegions test = new SurroundedRegions();
        char[][] board = {{'O','X','X','O'},
                          {'X','O','O','X'},
                          {'O','X','O','X'},
                          {'X','O','X','O'}};
        test.solve(board);
        for (char[] row : board) {
            System.out.println(Arrays.toString(row));
        }
    }
}