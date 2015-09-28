public class SetMatrixZeros {
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0
            || matrix[0] == null || matrix[0].length == 0) {
            return;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        boolean zeroColumn = false;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                zeroColumn = true;
                break;
            }
        }
        boolean zeroRow = false;
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                zeroRow = true;
                break;
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < m; i++) {
            if (matrix[i][0] == 0) {
                Arrays.fill(matrix[i], 0);
            }
        }
        for (int j = 1; j < n; j++) {
            if (matrix[0][j] == 0) {
                for (int k = 0; k < m; k++) {
                    matrix[k][j] = 0;
                }
            }
        }
        if (zeroRow) {
            Arrays.fill(matrix[0], 0);
        }
        if (zeroColumn) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}