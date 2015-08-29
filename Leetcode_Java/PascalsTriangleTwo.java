import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleTwo {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> pre = new ArrayList<>();
        pre.add(1);
        if (rowIndex == 0) {
            return pre;
        }
        for (int i = 1; i <= rowIndex; i++) {
            List<Integer> cur = new ArrayList<>();
            cur.add(1);
            for (int j = 1; j < i; j++) {
                cur.add(pre.get(j - 1) + pre.get(j));
            }
            cur.add(1);
            pre = cur;
        }
        return pre;
    }

    public static void main(String[] args) {
        PascalsTriangleTwo test = new PascalsTriangleTwo();
        int rowIndex = 4;
        System.out.println(test.getRow(rowIndex));
    }
}