import java.util.Map;
import java.util.HashMap;

public class RomanToInteger {
    public int romanToInt(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int result = 0;
        int i = 0;
        while (i < s.length() - 1) {
            if (map.get(s.charAt(i)) >= map.get(s.charAt(i + 1))) {
                result += map.get(s.charAt(i));
                i++;    
            } else {
                result += map.get(s.charAt(i + 1)) - map.get(s.charAt(i));
                i += 2;
            }
        }
        if (i == s.length() - 1) {
                result += map.get(s.charAt(i));
            }
        return result;
    }

    public static void main(String[] args) {
        RomanToInteger test = new RomanToInteger();
        String s = "MDCXCV";
        System.out.println(test.romanToInt(s));
    }
}