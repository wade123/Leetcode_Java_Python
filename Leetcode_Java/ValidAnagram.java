import java.util.Map;
import java.util.HashMap;

public class ValidAnagram {
// sort the charArray
    public boolean isAnagram(String s, String t) {
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        Arrays.sort(sArray);
        Arrays.sort(tArray);
        return String.valueOf(sArray).equals(String.valueOf(tArray));
    }
//using hash map
    public boolean isAnagram(String s, String t) {
        return getStringMap(s).equals(getStringMap(t));
    }

    private Map<String, Integer> getStringMap(String s) {
        String[] sArray = s.split("");
        Map<String, Integer> map = new HashMap<>();
        for (String str : sArray) {
            if (!map.containsKey(str)) {
                map.put(str, 1);
            } else {
                map.put(str, map.get(str) + 1);
            }
        }
        return map;
    }

    public static void main(String[] args) {
        ValidAnagram test = new ValidAnagram();
        String s = "abcd";
        String t = "dbac";
        System.out.println(test.isAnagram(s, t));
    }
}