import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

public class CombinationSumTwo {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return result;
        }
        Arrays.sort(candidates);
        List<Integer> list = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        combinationSumHelper(candidates, target, set, list, 0);
        result = new ArrayList<>(set);
        return result;
    }

    private void combinationSumHelper(int[] candidates, int target,
        Set<List<Integer>> set, List<Integer> list, int index) {
        if (target == 0) {
            set.add(new ArrayList<Integer>(list));
            return;
        }
        if (target < 0 || index >= candidates.length) {
            return;
        }
        combinationSumHelper(candidates, target, set, list, index + 1);
        list.add(candidates[index]);
        combinationSumHelper(candidates, target - candidates[index], set, list, index + 1);
        list.remove(list.size() - 1);
    }

    public static void main(String[] args) {
        CombinationSumTwo test = new CombinationSumTwo();
        int[] candidates = {2, 2, 2, 2, 2, 2};
        int target = 6;
        System.out.println(test.combinationSum2(candidates, target));
    }
}