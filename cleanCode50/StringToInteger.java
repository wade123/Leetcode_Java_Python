public class StringToInteger {
    private static final int MAXDIV10 = Integer.MAX_VALUE / 10;

    public int myAtoi(String str) {
        int i = 0;
        int length = str.length();
        while (i < length && Character.isWhitespace(str.charAt(i))) {
            i++;
        }
        int sign = 1;
        if (i < length && str.charAt(i) == '+') {
            i++;
        } else if (i < length && str.charAt(i) == '-') {
            i++;
            sign = -1;
        }
        int number = 0;
        while (i < length && Character.isDigit(str.charAt(i))) {
            int digit = Character.getNumericValue(str.charAt(i));
            if (number > MAXDIV10 || number == MAXDIV10 && digit >= 8) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            number = number * 10 + digit;
            i++;
        }
        return sign * number;
    }
}