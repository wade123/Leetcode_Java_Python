import java.util.Arrays;

public class RemoveDuplicatesFromSortedArrayTwo {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int j = 0;
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[j]) {
                j++;
                nums[j] = nums[i];
                count = 1;
            } else if (count < 2) {
                count++;
                j++;
                nums[j] = nums[i];
            } else {
                continue;
            }
        }
        System.out.println(Arrays.toString(nums));
        return j + 1;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArrayTwo test = new RemoveDuplicatesFromSortedArrayTwo();
        int[] nums = {1, 1, 2, 2, 2, 2, 3, 4, 4, 4};
        System.out.println(test.removeDuplicates(nums));
    }
}