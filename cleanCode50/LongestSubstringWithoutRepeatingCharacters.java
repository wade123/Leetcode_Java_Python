public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        boolean[] letters = new boolean[256];
        int start = 0;
        int max = 0;
        for (int end = 0; end < s.length(); end++) {
            while (letters[s.charAt(end)]) {
                letters[s.charAt(start)] = false;
                start++;
            }
            letters[s.charAt(end)] = true;
            max = Math.max(max, end - start + 1);
        }
        return max;
    }
}