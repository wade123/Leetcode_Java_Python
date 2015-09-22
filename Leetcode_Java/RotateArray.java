public class RotateArray {
    public void rotate(int[] nums, int k) {
        int length = nums.length;
        k %= length;
        if (k == 0) {
            return;
        }
        reverse(nums, 0, length - 1 - k);
        reverse(nums, length - k, length - 1);
        reverse(nums, 0, length - 1);
    }

    private void reverse(int[] nums, int left, int right) {
        int p = left;
        int q = right;
        while (p < q) {
            int temp = nums[p];
            nums[p] = nums[q];
            nums[q] = temp;
            p++;
            q--;
        }
    }
}