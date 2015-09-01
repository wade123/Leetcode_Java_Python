public class HouseRobberTwo {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(robHelper(nums, 0, nums.length - 2), robHelper(nums, 1, nums.length - 1));
        
    }

    public int robHelper(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }
        int a = nums[left];
        int b = Math.max(nums[left], nums[left + 1]);
        for (int i = left + 2; i <= right; i++) {
            int c = Math.max(a + nums[i], b);
            a = b;
            b = c;
        }
        return b;
    }
}