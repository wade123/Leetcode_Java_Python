public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while (true) {
            for (int j = 0; j < strs.length; j++) {
                if (i >= strs[j].length()) {
                    return sb.toString();
                }
                if (j != 0 && strs[j].charAt(i) != strs[j - 1].charAt(i)) {
                    return sb.toString();
                }
            }
            sb.append(strs[0].charAt(i));
            i++;
        }
    }

    public static void main(String[] args) {
        LongestCommonPrefix test = new LongestCommonPrefix();
        String[] strs = {"abc", "abcd","abc"};
        System.out.println(test.longestCommonPrefix(strs));
    }
}