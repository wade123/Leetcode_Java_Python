import java.util.*;

public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] output = new int[length];
        Arrays.fill(output, 1);
        int left = 1;
        for (int i = 1; i < length; i++) {
            left *= nums[i - 1];
            output[i] *= left;
        }
        int right = 1;
        for (int i = length - 2; i >= 0; i--) {
            right *= nums[i + 1];
            output[i] *= right;
        }
        return output;
    }

    public static void main(String[] args) {
        ProductOfArrayExceptSelf test = new ProductOfArrayExceptSelf();
        int[] nums = {1, 2, 3, 4};
        System.out.println(Arrays.toString(test.productExceptSelf(nums)));
    }
}