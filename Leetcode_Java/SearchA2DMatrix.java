public class SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int start = 0;
        int end = m * n - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            int i = mid / n;
            int j = mid % n;
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] > target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (matrix[start / n][start % n] == target
            || matrix[end / n][end % n] == target) {
            return true;
        } else {
            return false;
        }
    }
}