import java.util.*;

public class GrayCode {
    public List<Integer> grayCode(int n) {
        List<Integer> grayCode = new ArrayList<>();
        if (n == 0) {
            grayCode.add(0);
            return grayCode;
        }
        grayCode.add(0);
        grayCode.add(1);
        if (n == 1) {   
            return grayCode;
        }
        for (int i = 2; i <= n; i++) {
            int size = grayCode.size();
            for (int j = size - 1; j >= 0; j--) {
                grayCode.add(grayCode.get(j) + (1 << (i - 1)));
                //grayCode.add((int) (grayCode.get(j) + Math.pow(2, i - 1)));
            }
        }
        return grayCode;
    }

    public static void main(String[] args) {
        GrayCode test = new GrayCode();
        System.out.println(test.grayCode(3).toString());
    }
}