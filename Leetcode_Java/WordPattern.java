import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

public class WordPattern {
    public boolean wordPattern(String pattern, String str) {
        char[] patternArray = pattern.toCharArray();
        String[] strArray = str.split("\\s+");
        //System.out.println(Arrays.toString(patternArray));
        //System.out.println(Arrays.toString(strArray));
        if (patternArray.length != strArray.length) {
            return false;
        }
        Map<Character, String> map = new HashMap<>();
        for (int i = 0; i < patternArray.length; i++) {
            if (!map.containsKey(patternArray[i])) {
                map.put(patternArray[i], strArray[i]);
            } else if (map.get(patternArray[i]).equals(strArray[i])) {
                continue;
            } else {
                return false;
            }
        }
        Set<String> set = new HashSet<>();
        for (String value : map.values()) {
            if (!set.contains(value)) {
                set.add(value);
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        WordPattern test = new WordPattern();
        System.out.println(test.wordPattern("abba", "dog dog dog dog"));
    }
}