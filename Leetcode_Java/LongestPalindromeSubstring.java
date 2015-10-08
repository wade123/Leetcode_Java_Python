public class LongestPalindromeSubstring {
    public String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        int length = s.length();
        boolean[][] isPalindrome = new boolean[length][length];
        for (int i = 0; i < length; i++) {
            isPalindrome[i][i] = true;
        }
        int maxLen = 0;
        String longestStr = null;
        for (int j = 1; j < length; j++) {
            for (int i = 0; i < j; i++) {
                if (s.charAt(i) == s.charAt(j) && (j == i + 1
                    || isPalindrome[i + 1][j - 1])) {
                    isPalindrome[i][j] = true;
                    if (j - i + 1 > maxLen) {
                        maxLen = j - i + 1;
                        longestStr = s.substring(i, j + 1);
                    }
                }
            }
        }
        return longestStr;
    }

    public String longestPalindrome2(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        int len = s.length();
        int maxLen = Integer.MIN_VALUE;
        String maxString = null;
        for (int i = 1; i < len - 1; i++) {
            int start = i - 1;
            int end = i + 1;
            while (start >= 0 && end < len
                && s.charAt(start) == s.charAt(end)) {
                start--;
                end++;
            }
            if (end - start - 1 > maxLen) {
                maxLen = end - start - 1;
                maxString = s.substring(start + 1, end);
            }
        }
        for (int i = 0; i < len - 1; i++) {
            int start = i;
            int end = i + 1;
            while (start >= 0 && end < len
                && s.charAt(start) == s.charAt(end)) {
                start--;
                end++;
            }
            if (end - start - 1 > maxLen) {
                maxLen = end - start - 1;
                maxString = s.substring(start + 1, end);
            }
        }
        return maxString;
    }

    public static void main(String[] args) {
        LongestPalindromeSubstring test = new LongestPalindromeSubstring();
        System.out.println(test.longestPalindrome("abcbaaaa"));
    }
}