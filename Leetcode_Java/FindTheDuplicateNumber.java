public class FindTheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        int low = 1;
        int high = nums.length - 1;
        while (low + 1 < high) {
            int mid = low + (high - low) / 2;
            if (countLessThanTarget(nums, mid) <= mid - 1) {
                low = mid;
            } else {
                high = mid;
            }
        }
        int count = 0;
        for(int i = 0; i < nums.length; i++) {
            if (nums[i] == low) {
                count++;
            }
        }
        return count >= 2 ? low : high;
    }

    private int countLessThanTarget(int[] nums, int target) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < target) {
                count++;
            }
        }
        return count;
    }

    public int findDuplicate2(int[] nums) {
        for (int i = 0; i <= nums.length; i++) {
            for (int j = i + 1; j <= nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return nums[i];
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        FindTheDuplicateNumber test = new FindTheDuplicateNumber();
        int[] nums = {1,4,4,2,4};
        System.out.println(test.findDuplicate(nums));
    }
}