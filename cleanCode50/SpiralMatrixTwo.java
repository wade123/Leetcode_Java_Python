import java.util.Arrays;

public class SpiralMatrixTwo {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        if (n == 0) {
            return matrix;
        }
        int a = 0;
        int count = 0;
        while (2*a < n - 1) {
            for (int i = a; i <= n - a - 2; i++) {
                matrix[a][i] = ++count;
            }
            for (int i = a; i <= n - a - 2; i++) {
                matrix[i][n - 1 - a] = ++count;
            }
            for (int i = n - 1 - a; i >= a + 1; i--) {
                matrix[n - 1 - a][i] = ++count;
            }
            for (int i = n - 1 - a; i >= a + 1; i--) {
                matrix[i][a] = ++count;
            }
            a++;
        }
        if (2*a == n - 1) {
            matrix[a][a] = ++count;
        }
        return matrix;
    }

    public static void main(String[] args) {
        SpiralMatrixTwo test = new SpiralMatrixTwo();
        int[][] matrix = test.generateMatrix(3);
        System.out.println(Arrays.deepToString(matrix));
        for (int[] array : matrix) {
            System.out.println(Arrays.toString(array));
        }
    }
}