import java.util.*;

public class ZigZagConversion {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        ArrayList<StringBuilder> list = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            list.add(new StringBuilder());
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            int remainder = i % (2 * numRows - 2);
            if (remainder <= numRows - 1) {
                list.get(remainder).append(s.charAt(i));
            } else {
                list.get(2 * numRows - 2 - remainder).append(s.charAt(i));
            }
        }
        for (int i = 0; i < numRows; i++) {
            sb.append(list.get(i).toString());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        ZigZagConversion test = new ZigZagConversion();
        System.out.println(test.convert("PAYPALISHIRING", 3));
    }
}