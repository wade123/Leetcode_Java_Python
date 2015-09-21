public class ReverseBits {
    // you need treat n as an unsigned value
    public int reverseBits1(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res |= ((n >> i) & 1) << (31 - i); 
        }
        return res;
    }

    public int reverseBits2(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & 1) == 1) {
                result++;
            }
            if (i != 31) {
                result <<= 1;
            }
            n >>= 1;
        }
        return result;
    }

    public int reverseBits3(int n) {
        int result = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0) { // using == 1 will get wrong answer, why?
                result++;
            }
            if (i != 31) {
                result <<= 1;
            }
            mask <<= 1;
        }
        return result;
    }

    public static void main(String[] args) {
        ReverseBits test = new ReverseBits();
        System.out.println(test.reverseBits1(2));
    }
}