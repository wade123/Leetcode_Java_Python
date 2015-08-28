import java.util.*;

public class HappyNumber {
// error handling
    public boolean isHappy(int n) {
        if (n == 1) {
            return true;
        }
        try {
            int temp = n;
            int result = 0;
            while (temp > 0) {
                result += Math.pow(temp % 10, 2);
                temp /= 10;
            }
            if (result == 1) {
                return true;
            }
            return isHappy(result);
        }
        catch (StackOverflowError error) {
            return false;
        }
    }
//using HashSet to detect infinite loop/recursion
    public boolean isHappy(int n) {
        if (n == 1) {
            return true;
        }
        Set<Integer> set = new HashSet<>();
        set.add(n);
        while (n > 1) {
            int temp = n;
            int result = 0;
            while (temp > 0) {
                result += Math.pow(temp % 10, 2);
                temp /= 10;
            }
            if (result == 1) {
                return true;
            } else if (!set.contains(result)) {
                set.add(result);
                n = result;
            } else {
                return false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        HappyNumber test = new HappyNumber();
        int n = 2;
        System.out.println(test.isHappy(n));
    }
}