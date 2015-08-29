public class NumberOf1Bits {
    // you need to treat n as an unsigned value
// O(32) time
    public int hammingWeight(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & 1) == 1) {
                count++;
            }
            n >>= 1;
        }
        return count;
    }
// O(numberOfBits) time, quicker, each time, it get rid of one '1' bit
    public int hammingWeight(int n) {
        int count = 0;  
        while(n != 0){  
            n = n & (n-1);  
            count++;  
        }  
        return count;
    }

    public static void main(String[] args) {
        NumberOf1Bits test = new NumberOf1Bits();
        System.out.println(test.hammingWeight(-1));
    }
}