import java.util.*;

public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        int i = 0;
        while (i < nums.length) {
            int start = i;
            int end = i;
            while (end + 1 < nums.length && nums[end] + 1 == nums[end + 1]) {
                end++;
            }
            if (start == end) {
                result.add(nums[start] + "");
            } else {
                result.add(nums[start] + "->" + nums[end]);
            }
            i = end + 1;
        }
        return result;
    }

    public static void main(String[] args) {
        SummaryRanges test = new SummaryRanges();
        int[] nums = {0,1,2,4,5,7};
        System.out.println(test.summaryRanges(nums));
    }
}