import java.util.*;

public class PascalsTriangle {
// one-pass better solution
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows <= 0) {
            return result;
        }
        List<Integer> pre = new ArrayList<Integer>();
        pre.add(1);
        result.add(pre);
        for (int i = 1; i < numRows; i++) {
            List<Integer> cur = new ArrayList<Integer>();
            cur.add(1);
            for (int j = 1; j < i; j++) {
                cur.add(pre.get(j - 1) + pre.get(j));
            }
            cur.add(1);
            result.add(cur);
            pre = cur;
        }
        return result;
    }
// two-pass: not as well
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows <= 0) {
            return result;
        }
        for (int i = 0; i < numRows; i++) {
            List<Integer> temp = new ArrayList<Integer>();
            result.add(temp);
            for (int j = 0; j <= i; j++) {
                temp.add(1);
            }
        }
        for (int i = 2 ; i < numRows; i++) {
            for (int j = 1; j < i; j++) {
                result.get(i).set(j, result.get(i - 1).get(j - 1)
                    + result.get(i - 1).get(j));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        PascalsTriangle test = new PascalsTriangle();
        int numRows = 4;
        List<List<Integer>> result = test.generate(numRows);
        System.out.println(result.toString());
    }
}