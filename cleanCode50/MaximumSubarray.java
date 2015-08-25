import java.util.Arrays;

public class MaximumSubarray {
// only find the maxSum
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = dp[i - 1] <= 0 ? nums[i] : nums[i] + dp[i - 1];
            max = Math.max(max, dp[i]);
        }
        return max;
    }
// find the max subarray
    public int[] maxSubArrayOut(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        int start = 0;
        int end = 0;
        int left = 0;
        int right = 0;
        for (int i = 1; i < nums.length; i++) {
            if (dp[i - 1] <= 0) {
                dp[i] = nums[i];
                start = i;
            } else {
                dp[i] = nums[i] + dp[i - 1];
                end = i;
            }
            if (dp[i] > max) {
                left = start;
                right = end;
                max = dp[i];
            }
        }
        int[] result = new int[right - left + 1];
        for (int i = 0; i <= right - left; i++) {
            result[i] = nums[left + i];
        }
        return result;
    }

    public static void main(String[] args) {
        MaximumSubarray test = new MaximumSubarray();
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(test.maxSubArray(nums));
        System.out.println(Arrays.toString(test.maxSubArrayOut(nums)));
    }
}