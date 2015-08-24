import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0
            || matrix[0] == null || matrix[0].length == 0) {
            return result;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int a = 0;
        while (2*a < m - 1 && 2*a < n - 1) {
            for (int i = a; i <= n - a - 2; i++) {
                result.add(matrix[a][i]);
            }
            for (int i = a; i <= m - a - 2; i++) {
                result.add(matrix[i][n - 1 - a]);
            }
            for (int i = n - 1 - a; i >= a + 1; i--) {
                result.add(matrix[m - 1 - a][i]);
            }
            for (int i = m - 1 - a; i >= a + 1; i--) {
                result.add(matrix[i][a]);
            }
            a++;
        }
        if (2*a == m - 1) {
            for (int i = a; i <= n - 1 - a; i++ ) {
                result.add(matrix[a][i]);
            }
        } else if (2*a == n - 1) {
            for (int i = a; i <= m - 1 - a; i++) {
                result.add(matrix[i][a]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        SpiralMatrix test = new SpiralMatrix();
        int[][] matrix = new int[3][3];
        System.out.println(Arrays.deepToString(matrix));
        System.out.println(test.spiralOrder(matrix).toString());
    }

}