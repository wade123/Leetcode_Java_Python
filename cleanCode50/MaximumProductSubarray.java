public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int maxPositive = nums[0];
        int minNegative = nums[0];
        int maxGlobal = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int maxTemp = maxPositive;
            int minTemp = minNegative;
            maxPositive = Math.max(nums[i], Math.max(nums[i] * maxTemp, nums[i] * minTemp));
            minNegative = Math.min(nums[i], Math.min(nums[i] * maxTemp, nums[i] * minTemp));
            maxGlobal = Math.max(maxGlobal, maxPositive);
        }
        return maxGlobal;
    }

    public static void main(String[] args) {
        MaximumProductSubarray test = new MaximumProductSubarray();
        int[] nums = {0, 2};
        System.out.println(test.maxProduct(nums));
    }
}