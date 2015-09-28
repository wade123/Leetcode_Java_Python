public class MissingNumber {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int i = 0;
        while (true) {
            while (i < n && nums[i] == i) {
                i++;
            }
            if (i < n && nums[i] != i && nums[i] != n && nums[nums[i]] != nums[i]) {
                int temp = nums[i];
                nums[i] = nums[nums[i]];
                nums[temp] = temp;
            }
            if (i < n && (nums[i] == n || nums[nums[i]] == nums[i])) {
                i++;
            }
            if (i == n) break;
        }
        for (int j = 0; j < n; j++) {
            if (nums[j] != j) {
                return j;
            }
        }
        return n;
    }

    public int missingNumber2(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int number : nums) {
            sum += number;
        }
        return n * (n + 1) / 2 - sum;
    }

    public int missingNumber3(int[] nums) {
        int result = nums.length;
        for (int i = 0; i < nums.length; i++) {
            result ^= i ^ nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        MissingNumber test = new MissingNumber();
        int[] nums = {1};
        System.out.println(test.missingNumber(nums));
    }
}