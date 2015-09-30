import java.util.ArrayList;
import java.util.List;

public class Permutations {
    private List<List<Integer>> result;

    public List<List<Integer>> permute(int[] nums) {
        result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        List<Integer> list = new ArrayList<>();
        permuteHelper(nums, 0, list);
        return result;
    }

    private void permuteHelper(int[] nums, int index, List<Integer> list) {
        if (index == nums.length) {
            result.add(new ArrayList<Integer>(list));
        }
        for (int i = 0; i < nums.length; i++) {
            if (!list.contains(nums[i])) {
                list.add(nums[i]);
                permuteHelper(nums, index + 1, list);
                list.remove(list.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Permutations test = new Permutations();
        int[] nums = {1, 2, 3};
        System.out.println(test.permute(nums));
    }
}