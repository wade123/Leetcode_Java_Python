import java.util.ArrayList;
import java.util.List;

public class Combinations {
    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        if (k <= 0) {
            return result;
        }
        List<Integer> list = new ArrayList<>();
        combineHelper(n, k, 1, list);
        return result;
    }

    private void combineHelper(int n, int k, int index, List<Integer> list) {
        if (k == 0) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i <= n - k + 1; i++) {
            list.add(i);
            combineHelper(n, k - 1, i + 1, list);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        Combinations test = new Combinations();
        System.out.println(test.combine(4, 3));
    }
}