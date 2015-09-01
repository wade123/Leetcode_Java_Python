public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int length = s.length();
        int i = s.length() - 1;
        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }
        if (i == -1) {
            return 0;
        }
        int end = i;
        while (i >= 0 && s.charAt(i) != ' ') {
            i--;
        }
        return end - i;
    }
}