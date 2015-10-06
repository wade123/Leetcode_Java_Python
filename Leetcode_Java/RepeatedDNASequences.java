import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class RepeatedDNASequences {
// map each 10-character string to a 20 bit integer to save space
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<>();
        if (s == null || s.length() <= 10) {
            return result;
        }
        int hash = 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>() {{
            put('A', 0);
            put('C', 1);
            put('G', 2);
            put('T', 3);
        }}; 
        Map<Integer, Integer> sequenceCount = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            hash = (hash << 2) + map.get(s.charAt(i));
            if (i >= 9) {
                hash &= (1 << 20) - 1;
                if (!sequenceCount.containsKey(hash)) {
                    sequenceCount.put(hash, 1);
                } else if (sequenceCount.get(hash) == 1) {
                    sequenceCount.put(hash, sequenceCount.get(hash) + 1);
                    result.add(s.substring(i - 9, i + 1));
                }
            }
        }
        return result;
    }
// naive approach
    public List<String> findRepeatedDnaSequences2(String s) {
        List<String> result = new ArrayList<>();
        if (s == null || s.length() <= 10) {
            return result;
        }
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length() - 9; i++) {
            String cur = s.substring(i, i + 10);
            if (!map.containsKey(cur)) {
                map.put(cur, 1);
            } else if (map.get(cur) == 1) {
                map.put(cur, map.get(cur) + 1);
                result.add(cur);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        RepeatedDNASequences test = new RepeatedDNASequences();
        System.out.println(test.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
    }
}