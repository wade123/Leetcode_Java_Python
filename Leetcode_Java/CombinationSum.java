import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return result;
        }
        Arrays.sort(candidates);
        List<Integer> list = new ArrayList<>();
        combinationSumHelper(candidates, target, result, list, 0);
        return result;
    }

    private void combinationSumHelper(int[] candidates, int target,
        List<List<Integer>> result, List<Integer> list, int index) {
        if (target == 0) {
            result.add(new ArrayList<Integer>(list));
            return;
        }
        if (target < 0 || index >= candidates.length) {
            return;
        }
        combinationSumHelper(candidates, target, result, list, index + 1);
        list.add(candidates[index]);
        combinationSumHelper(candidates, target - candidates[index], result, list, index);
        list.remove(list.size() - 1);
    }

    public static void main(String[] args) {
        CombinationSum test = new CombinationSum();
        int[] candidates = {2, 3, 6};
        int target = 8;
        System.out.println(test.combinationSum(candidates, target));
    }
}