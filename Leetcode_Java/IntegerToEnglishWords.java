import java.util.*;

public class IntegerToEnglishWords {
    private Map<Integer, String> ones = new HashMap<Integer, String>() {{
        put(1, "One"); put(2, "Two"); put(3, "Three"); put(4, "Four");
        put(5, "Five"); put(6, "Six"); put(7, "Seven"); put(8, "Eight");
        put(9, "Nine"); put(10, "Ten"); put(11, "Eleven"); put(12, "Twelve");
        put(13, "Thirteen"); put(14, "Fourteen");
        put(15, "Fifteen"); put(16, "Sixteen");
        put(17, "Seventeen"); put(18, "Eighteen"); put(19, "Nineteen");
    }};

    private Map<Integer, String> tens = new HashMap<Integer, String>() {{
        put(2, "Twenty"); put(3, "Thirty"); put(4, "Forty");
        put(5, "Fifty"); put(6, "Sixty"); put(7, "Seventy");
        put(8, "Eighty"); put(9, "Ninety");
    }};

    private Map<Integer, String> thousands = new HashMap<Integer, String>() {{
        put(0, ""); put(1, "Thousand"); put(2, "Million"); put(3, "Billion");
    }};

    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        List<Integer> list = new ArrayList<>();
        while (num > 0) {
            list.add(num % 1000);
            num /= 1000;
        }
        List<String> result = new ArrayList<String>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != 0) {
                result.add(getString(list.get(i)) + thousands.get(i) + " ");
            }
        }
        Collections.reverse(result);
        StringBuilder sb = new StringBuilder();
        for (String str : result) {
            sb.append(str);
        }
        String out = sb.toString();
        int end = out.length() - 1;
        while (end >= 0) {
            if (out.charAt(end) == ' ') {
                end--;
            } else {
                break;
            }
        }
        return out.substring(0, end + 1);
    }

    private String getString(int n) {
        StringBuilder sb = new StringBuilder();
        int hundred = n / 100;
        if (hundred > 0) {
            sb.append(ones.get(hundred) + " ");
            sb.append("Hundred" + " ");
        }
        int r = n % 100;
        if (r > 0 && r <= 19) {
            sb.append(ones.get(r) + " ");
            return sb.toString();
        } else if (r >= 20 && r <= 99) {
            int h = r / 10;
            int digit = r % 10;
            sb.append(tens.get(h) + " ");
            if (digit != 0) {
                sb.append(ones.get(digit) + " ");
            }
            return sb.toString();
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        IntegerToEnglishWords test = new IntegerToEnglishWords();
        int n = 1000;
        System.out.println(test.numberToWords(n));
    }
}