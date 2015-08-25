public class ClimbingStairs {
    public int climbStairs(int n) {
        int a = 1;
        int b = 1;
        int c = 0;
        while (n > 1) {
            c = a + b;
            a = b;
            b = c;
            n--;
        }
        return b;
    }
}