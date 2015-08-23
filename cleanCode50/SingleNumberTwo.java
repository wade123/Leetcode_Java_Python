public class Solution {
// using map
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int number : nums) {
            if (map.containsKey(number)) {
                map.put(number, map.get(number) + 1);
            } else {
                map.put(number, 1);
            }
        }
        for (Integer key : map.keySet()) {
            if (map.get(key) == 1) {
                return key;
            }
        }
        return -1;
    }
// bit manipunation
    public int singleNumber(int[] nums) {
        int length = nums.length;
        int result = 0;
        int[] count = new int[32];
        for (int i = 0; i < 32; i++) {
            for (int j = 0; j < length; j++) {
                if (((nums[j] >> i) & 1) == 1) {
                    count[i]++;
                }
            }
            result |= ((count[i] % 3) << i);
        }
        return result;
    }
// bit manipulation 2
    public int singleNumber(int[] nums) {
        int ones = 0;
        int twos = 0;
        int threes = 0;
        for (int number : nums) {
            twos |= ones & number;
            ones ^= number;
            threes = ones & twos;
            ones &= ~threes;
            twos &= ~threes;
        }
        return ones;
    }
}