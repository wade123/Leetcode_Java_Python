public class AddDigits {
    public int addDigits(int num) {
        return (num - 1) % 9 + 1;
    }
    
    public int addDigits(int num) {
        while (num >= 10) {
            char[] nums = String.valueOf(num).toCharArray();
            int number = 0;
            for (char chr : nums) {
                number += Character.getNumericValue(chr);
            }
            num = number;
        }
        return num;
    }

    public int addDigits(int num) {
        if (num < 10) {
            return num;
        }
        char[] nums = String.valueOf(num).toCharArray();
        int number = 0;
        for (char chr : nums) {
            number += Character.getNumericValue(chr);
        }
        return addDigits(number);
    }

    public static void main(String[] args) {
        AddDigits test = new AddDigits();
        int num = 38;
        System.out.println(test.addDigits(num));
    }
}