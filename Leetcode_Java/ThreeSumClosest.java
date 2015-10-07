import java.util.Arrays;

public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return Integer.MAX_VALUE;
        }
        int len = nums.length;
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE;
        int resultSum = Integer.MAX_VALUE;
        for (int i = 0; i < len - 2; i++) {
            int start = i + 1;
            int end = len - 1;
            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if (sum == target) {
                    return sum;
                } else if (sum < target) {
                    start++;
                } else {
                    end--;
                }
                if (Math.abs(sum - target) < diff) {
                    diff = Math.abs(sum - target);
                    resultSum = sum;
                }
            }
        }
        return resultSum;
    }

    public static void main(String[] args) {
        ThreeSumClosest test = new ThreeSumClosest();
        int[] nums = {-1, 2, 1, -4};
        int target = 1;
        System.out.println(test.threeSumClosest(nums, target));
    }
}