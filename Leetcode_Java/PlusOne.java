import java.util.Arrays;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        int i = digits.length - 1;
        int carry = 1;
        int sum = 0;
        while (i >= 0) {
            sum = (digits[i] + carry) % 10;
            carry = (digits[i] + carry) / 10;
            digits[i--] = sum;
        }
        if (carry == 0) {
            return digits;
        } else {
            int[] result = new int[digits.length + 1];
            result[0] = carry;
            for (int j = 0; j < digits.length; j++) {
                result[j + 1] = digits[j];
            }
            return result;
        }
    }

    public static void main(String[] args) {
        PlusOne test = new PlusOne();
        int[] digits = {2, 3, 9, 9};
        System.out.println(Arrays.toString(test.plusOne(digits)));
    }
}