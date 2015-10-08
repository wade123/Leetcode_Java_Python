import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int size = triangle.size();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = triangle.get(size - 1).get(i);
        }
        for (int i = size - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                array[j] = triangle.get(i).get(j) + Math.min(array[j], array[j + 1]);
            }
        }
        return array[0];
    }

    public static void main(String[] args) {
        Triangle test = new Triangle();
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(new ArrayList<Integer>(Arrays.asList(2)));
        triangle.add(new ArrayList<Integer>(Arrays.asList(3, 4)));
        triangle.add(new ArrayList<Integer>(Arrays.asList(6, 5, 7)));
        triangle.add(new ArrayList<Integer>(Arrays.asList(4, 1, 8, 3)));
        System.out.println(test.minimumTotal(triangle));
    }
}