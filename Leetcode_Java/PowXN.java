public class PowXN {
    public double myPow(double x, int n) {
        if (x == 1 || x == -1) {
            return n % 2 == 0 ? 1.0 : x;
        }
        if (n == 0) {
            return 1.0;
        }
        if (n < 0) {
            return 1.0 / myPow(x, -n);
        }
        double out = myPow(x, n / 2);
        if (n % 2 == 1) {
            return out * out * x;
        } else {
            return out * out;
        }
    }

    public static void main(String[] args) {
        PowXN test = new PowXN();
        System.out.println(test.myPow(2, Integer.MAX_VALUE));
    }
}