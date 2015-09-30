import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class PermutationsTwo {
    private List<List<Integer>> result;

    public List<List<Integer>> permuteUnique(int[] nums) {
        result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        int[] visited = new int[nums.length];
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        permuteHelper(nums, visited, 0, list);
        return result;
    }

    private void permuteHelper(int[] nums, int[] visited, int index, List<Integer> list) {
        if (index == nums.length) {
            result.add(new ArrayList<Integer>(list));
        }
        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i - 1] && visited[i - 1] == 0) {
                continue;
            }
            if (visited[i] == 0) {
                list.add(nums[i]);
                visited[i] = 1;
                permuteHelper(nums, visited, index + 1, list);
                visited[i] = 0;
                list.remove(list.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        PermutationsTwo test = new PermutationsTwo();
        int[] nums = {2, 1, 2};
        System.out.println(test.permuteUnique(nums));
    }
}