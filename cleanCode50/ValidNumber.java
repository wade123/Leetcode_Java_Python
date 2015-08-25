public class ValidNumber {
    public boolean isNumber(String s) {
        int i = 0;
        int length = s.length();
        while (i < length && Character.isWhitespace(s.charAt(i))) {
            i++;
        }
        if (i < length && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            i++;
        }
        boolean isValidNumber = false;
        while (i < length && Character.isDigit(s.charAt(i))) {
            i++;
            isValidNumber = true;
        }
        if (i < length && s.charAt(i) == '.') {
            i++;
            while (i < length && Character.isDigit(s.charAt(i))) {
                i++;
                isValidNumber = true;
            }
        }
        if (isValidNumber && i < length && s.charAt(i) == 'e') {
            isValidNumber = false;
            i++;
            if (i < length && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
                i++;
            }
            while (i < length && Character.isDigit(s.charAt(i))) {
                isValidNumber = true;
                i++;
            }
        }
        while (i < length && Character.isWhitespace(s.charAt(i))) {
            i++;
        }
        return isValidNumber && i == length;
    }
}