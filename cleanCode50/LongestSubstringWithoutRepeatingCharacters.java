import java.util.Arrays;

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

    public int lengthOfLongestSubstring2(String s) {
        int[] index = new int[256];
        Arrays.fill(index, -1);
        int i = 0;
        int max = 0;
        for (int j = 0; j < s.length(); j++) {
            if (index[s.charAt(j)] >= i) {
                i = index[s.charAt(j)] + 1;
            }
            index[s.charAt(j)] = j;
            max = Math.max(max, j - i + 1);
        }
        return max;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters test =
        new LongestSubstringWithoutRepeatingCharacters();
        String s = "abcdecfgh";
        System.out.println(test.lengthOfLongestSubstring(s));
        System.out.println(test.lengthOfLongestSubstring2(s));
    }
}