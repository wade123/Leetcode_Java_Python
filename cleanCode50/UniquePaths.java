public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int[] pre = new int[n];
        int[] cur = new int[n];
        Arrays.fill(pre, 1);
        for (int i = 1; i < m; i++) {
            cur = new int[n];
            cur[0] = 1;
            for (int j = 1; j < n; j++) {
                cur[j] = pre[j] + cur[j - 1];
            }
            pre = cur;
        }
        return pre[n - 1];
    }
}