import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Collections;
import java.util.Set;
import java.util.HashSet;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return result;
        }
        Arrays.sort(nums);
        Map<Integer, Integer> map = new HashMap<>();
        //Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int target = - nums[i];
            int last = -1;
            for (int j = i + 1; j < nums.length; j++) {
                if (last != -1 && nums[j] == nums[last]) {
                    continue;
                }
                if (map.containsKey(target - nums[j])) {
                    List<Integer> list = new ArrayList<>(
                        Arrays.asList(nums[i], target - nums[j], nums[j]));
                    last = j;
                    result.add(list);
                }
                
                map.put(nums[j], j);
            }
            map.clear();
        }
        //return new ArrayList<>(set);
        return result;
    }

    public static void main(String[] args) {
        ThreeSum test = new ThreeSum();
        int[] nums = {7,-1,14,-12,-8,7,2,-15,8,8,-8,-14,-4,-5,7,9,11,-4,-15,-6,1,-14,4,3,10,-5,2,1,6,11,2,-2,-5,-7,-6,2,-15,11,-6,8,-4,2,1,-1,4,-6,-15,1,5,-15,10,14,9,-8,-6,4,-6,11,12,-15,7,-1,-9,9,-1,0,-4,-1,-12,-2,14,-9,7,0,-3,-4,1,-2,12,14,-10,0,5,14,-1,14,3,8,10,-8,8,-5,-2,6,-11,12,13,-7,-12,8,6,-13,14,-2,-5,-11,1,3,-6};
        System.out.println(test.threeSum(nums));
    }
}