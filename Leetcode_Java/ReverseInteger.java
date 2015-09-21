public class ReverseInteger {
    public int reverse(int x) {
        int sign = 1;
        if (x == Integer.MIN_VALUE) {
            return 0;
        }
        if (x < 0) {
            sign = -1;
            x = -x;
        }
        int result = 0;
        while (x > 0) {
            if (result > Integer.MAX_VALUE / 10) {
                return 0;
            }
            result = result * 10 + x % 10;
            x /= 10;
        }
        return sign * result;
    }

    public static void main(String[] args) {
        ReverseInteger test = new ReverseInteger();
        System.out.println(test.reverse(-123456));
    }
}