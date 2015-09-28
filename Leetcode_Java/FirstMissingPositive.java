public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        int i = 0;
        while (i < n) {
            if (nums[i] >= 1 && nums[i] <= n && nums[i] != i + 1
                && nums[i] != nums[nums[i] - 1]) {
                int temp = nums[i];
                nums[i] = nums[nums[i] - 1];
                nums[temp - 1] = temp;
            } else {
                i++;
            }
        }
        for (int j = 0; j < n; j++) {
            if (nums[j] != j + 1) {
                return j + 1;
            }
        }
        return n + 1;
    }

    public static void main(String[] args) {
        FirstMissingPositive test = new FirstMissingPositive();
        int[] nums = {3,4,-1,1};
        System.out.println(test.firstMissingPositive(nums));
    }
}