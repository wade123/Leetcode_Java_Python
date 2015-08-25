import java.util.*;

public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        Set<String> operators = new HashSet<>(Arrays.asList("+", "-", "*", "/"));
        for (String token : tokens) {
            if (operators.contains(token)) {
                int right = stack.pop();
                int left = stack.pop();
                stack.push(eval(left, right, token));
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    private int eval(int a, int b, String token) {
        if (token.equals("+")) {
            return a + b;
        } else if (token.equals("-")) {
            return a - b;
        } else if (token.equals("*")) {
            return a * b;
        } else {
            return a / b;
        }
    }

    public static void main(String[] args) {
        EvaluateReversePolishNotation test = new EvaluateReversePolishNotation();
        String[] tokens = {"4", "13", "5", "/", "+"};
        System.out.println(test.evalRPN(tokens));
    }
}