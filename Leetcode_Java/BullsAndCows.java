import java.util.Map;
import java.util.HashMap;

public class BullsAndCows {
    public String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        int length = secret.length();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            char character = guess.charAt(i);
            if (!map.containsKey(character)) {
                map.put(character, 1);
            } else {
                map.put(character, map.get(character) + 1);
            }
        }
        for (int i = 0; i < length; i++) {
            char chr = secret.charAt(i);
            if (map.containsKey(chr) && map.get(chr) > 0) {
                map.put(chr, map.get(chr) - 1);
                cows++;
            }
            if (secret.charAt(i) == guess.charAt(i)) {
                bulls++;
                cows--;
            }
        }
        String result = bulls + "A" + cows + "B";
        return result;
    }

    public static void main(String[] args) {
        BullsAndCows test = new BullsAndCows();
        System.out.println(test.getHint("11", "10"));
    }
}