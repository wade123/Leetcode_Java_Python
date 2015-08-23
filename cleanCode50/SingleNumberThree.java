import java.util.Arrays;

public class SingleNumberThree {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for (int number : nums) {
            xor ^= number;
        }
        int check = xor & ~(xor - 1);
        int one = 0;
        int two = 0;
        for (int number : nums) {
            if ((number & check) == 0) {
                one ^= number;
            } else {
                two ^= number;
            }
        }
        int[] result = {one, two};
        return result;
    }

    public static void main(String[] args) {
        SingleNumberThree test = new SingleNumberThree();
        int[] nums = {1, 1, 2, 2, 3, 4};
        System.out.println(Arrays.toString(test.singleNumber(nums)));
    }
}