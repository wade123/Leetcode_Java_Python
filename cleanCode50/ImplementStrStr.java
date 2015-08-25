public class ImplementStrStr {
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null || needle.length() > haystack.length()) {
            return -1;
        }
        int lengthHaystack = haystack.length();
        int lengthNeedle = needle.length();
        if (lengthNeedle == 0) {
            return 0;
        }
        for (int i = 0; i <= lengthHaystack - lengthNeedle; i++) {
            int j = 0;
            while (j < lengthNeedle) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                } else {
                    j++;
                }
                if (j == lengthNeedle) {
                    return i;
                }
            }
        }
        return -1;
    }
}