public class UniquePathsTwo {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] pre = new int[n];
        int[] cur = new int[n];
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i] == 0) {
                pre[i] = 1;
            } else {
                break;
            }
        }
        for (int i = 1; i < m; i++) {
            cur = new int[n];
            cur[0] = pre[0] != 0 && obstacleGrid[i][0] == 0 ? 1 : 0;
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    cur[j] = 0;
                } else {
                    cur[j] = pre[j] + cur[j - 1];
                }
            }
            pre = cur;
        }
        return pre[n - 1];
    }
}