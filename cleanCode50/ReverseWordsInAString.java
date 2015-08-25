public class ReverseWordsInAString {
    public String reverseWords(String s) {
        if (s.length() == 0) {
            return "";
        }
        StringBuilder result = new StringBuilder();
        int i = s.length() - 1;
        while (i >= 0) {
            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
            }
            int j = i + 1;
            while (i >= 0 && s.charAt(i) != ' ') {
                i--;
            }
            result.append(s.substring(i + 1, j));
            result.append(" ");
        }
        if (result.length() == 1) {
            return "";
        } else {
            int j = result.length() - 1;
            while (j >= 0 && result.charAt(j) == ' ') {
                j--;
            }
            return result.substring(0, j + 1);
        }
    }
}