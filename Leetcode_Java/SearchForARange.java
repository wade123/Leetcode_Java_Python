import java.util.Arrays;

public class SearchForARange {
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        if (nums == null || nums.length == 0) {
            return result;
        }
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] >= target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        if (start < nums.length && nums[start] == target) {
        // if not found, start will be length, outbound
            result[0] = start;
        } else {
            return result;
        }
        start = 0;
        end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        result[1] = end;
        return result;
    }

    public static void main(String[] args) {
        SearchForARange test = new SearchForARange();
        int[] nums = {1};
        int target = 1;
        System.out.println(Arrays.toString(test.searchRange(nums, target)));
    }
}