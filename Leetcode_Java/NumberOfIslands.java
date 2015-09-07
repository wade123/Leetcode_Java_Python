public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    count++;
                    dfs(grid, visited, i, j);
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, boolean[][] visited, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;
        visited[i][j] = true;
        if (i >= 1 && grid[i - 1][j] == '1' && !visited[i - 1][j]) {
            dfs(grid, visited, i - 1, j);
        }
        if (i < m - 1 && grid[i + 1][j] == '1' && !visited[i + 1][j]) {
            dfs(grid, visited, i + 1, j);
        }
        if (j >= 1 && grid[i][j - 1] == '1' && !visited[i][j - 1]) {
            dfs(grid, visited, i, j - 1);
        }
        if (j < n - 1 && grid[i][j + 1] == '1' && !visited[i][j + 1]) {
            dfs(grid, visited, i, j + 1);
        }
    }

    public static void main(String[] args) {
        NumberOfIslands test = new NumberOfIslands();
        char[][] grid = {{'1', '1', '1', '1', '0'},
                         {'1', '1', '0', '1', '0'},
                         {'1', '1', '0', '0', '0'},
                         {'0', '0', '0', '0', '0'}};
        System.out.println(test.numIslands(grid));
    }
}