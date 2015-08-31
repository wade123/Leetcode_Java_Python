public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0
            || grid[0] == null || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int[] pre = new int[n];
        int[] cur = new int[n];
        pre[0] = grid[0][0];
        for (int i = 1; i < n; i++) {
            pre[i] = pre[i - 1] + grid[0][i];
        }
        for (int i = 1; i < m; i++) {
            cur = new int[n];
            cur[0] = pre[0] + grid[i][0];
            for (int j = 1; j < n; j++) {
                cur[j] = Math.min(cur[j - 1], pre[j]) + grid[i][j];
            }
            pre = cur;
        }
        return pre[n - 1];
    }
}