import java.util.*;

public class GenerateParentheses {
    private List<String> result = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        StringBuilder sb = new StringBuilder();
        dfs(n, 0, 0, sb);
        return result;
    }

    private void dfs(int n, int left, int right, StringBuilder sb) {
        if (left == n && right == n) {
            result.add(sb.toString());
            return;
        }
        if (left > n || right > n || left < right) {
            return;
        }
        sb.append('(');
        dfs(n, left + 1, right, sb);
        sb.deleteCharAt(sb.length() - 1);
        sb.append(')');
        dfs(n, left, right + 1, sb);
        sb.deleteCharAt(sb.length() - 1);
    }

    public static void main(String[] args) {
        GenerateParentheses test = new GenerateParentheses();
        System.out.println(test.generateParenthesis(3));
    }
}