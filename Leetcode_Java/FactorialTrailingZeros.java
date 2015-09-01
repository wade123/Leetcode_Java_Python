public class FactorialTrailingZeros {
    public int trailingZeroes(int n) {
        if (n < 5) {
            return 0;
        }
        int zeros = 0;
        while (n >= 5) {
            zeros += n / 5;
            n /= 5;
        }
        return zeros;
    }
}