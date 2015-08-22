public class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int element : nums) {
            result ^= element;
        }
        return result;
    }
}