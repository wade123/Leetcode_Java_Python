import java.util.ArrayList;
import java.util.List;

public class CombinationSumThree {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        if (k > 9) {
            return result;
        }
        List<Integer> list = new ArrayList<>();
        combinationSum3Helper(k, n, result, list, 1);
        return result;
    }

    private void combinationSum3Helper(int k, int n, List<List<Integer>> result,
        List<Integer> list, int index) {
        if (k == 0 && n == 0) {
            result.add(new ArrayList<Integer>(list));
            return;
        }
        if (n < 0 || k == 0 || index > 9) {
            return;
        }
        combinationSum3Helper(k, n, result, list, index + 1);
        list.add(index);
        combinationSum3Helper(k - 1, n - index, result, list, index + 1);
        list.remove(list.size() - 1);
    }

    public static void main(String[] args) {
        CombinationSumThree test = new CombinationSumThree();
        System.out.println(test.combinationSum3(4, 24));
    }
}