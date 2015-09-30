import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {
    private Map<Character, String> map = new HashMap<Character, String>() {{
        put('2', "abc"); put('3', "def"); put('4', "ghi"); put('5', "jkl");
        put('6', "mno"); put('7', "pqrs"); put('8', "tuv"); put('9', "wxyz");
    }};

    List<String> result = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return result;
        }
        StringBuilder sb = new StringBuilder();
        letterCombinationsHelper(digits, 0, sb);
        return result;
    }

    private void letterCombinationsHelper(String digits, int index, StringBuilder sb) {
        if (index == digits.length()) {
            result.add(sb.toString());
            return;
        }
        String s = map.get(digits.charAt(index));
        for (int i = 0; i < s.length(); i++) {
            StringBuilder temp = new StringBuilder(sb);
            temp.append(s.charAt(i));
            letterCombinationsHelper(digits, index + 1, temp);
        }
    }

    public static void main(String[] args) {
        LetterCombinationsOfAPhoneNumber test = new LetterCombinationsOfAPhoneNumber();
        System.out.println(test.letterCombinations("2378"));
    }
}