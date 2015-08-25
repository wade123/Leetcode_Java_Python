import java.util.Map;
import java.util.HashMap;
import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        Stack<Character> stack = new Stack<>();
        for (char chr : s.toCharArray()) {
            if (map.containsKey(chr)) {
                stack.push(chr);
            } else if (stack.empty() || map.get(stack.pop()) != chr) {
                return false;
            }
        }
        return stack.empty();
    }

    public static void main(String[] args) {
        ValidParentheses test = new ValidParentheses();
        String s = "]";
        System.out.println(test.isValid(s));
    }
}