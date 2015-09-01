public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        } else if (x <= 9) {
            return true;
        }
        int k = 1;
        int number = x;
        while (number >= 10) {
            number /= 10;
            k *= 10;
        }
        while (x > 0) {
            int high = x / k;
            int low = x % 10;
            if (high != low) {
                return false;
            }
            x = (x - high * k) / 10;
            k /= 100;
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromeNumber test = new PalindromeNumber();
        System.out.println(test.isPalindrome(1221));
    }
}