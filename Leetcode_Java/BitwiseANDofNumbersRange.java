public class BitwiseANDofNumbersRange {
    public int rangeBitwiseAnd(int m, int n) {
        int count = 0;
        while (m != n) {
            m >>= 1;
            n >>= 1;
            count++;
        }
        return m << count;
    }

    public int rangeBitwiseAnd(int m, int n) {
        int mask = ~0;
        while ((m & mask) != (n & mask)) {
            mask <<= 1;
        }
        return mask & m;
    }

    public int rangeBitwiseAnd(int m, int n) {
        int result = ~0;
        for (int i = m; i <= n; i++) {
            result &= i;
        }
        return result;
    }
}