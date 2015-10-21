import java.util.Arrays;

public class HIndex {
    public int hIndex(int[] citations) {
        int[] count = new int[citations.length + 1];
        for (int citation : citations) {
            if (citation <= citations.length) {
                count[citation] += 1;
            } else {
                count[citations.length] += 1;
            }
        }
        int paper = 0;
        for (int i = citations.length; i >= 0; i--) {
            paper += count[i];
            if (paper >= i) {
                return i;
            }
        }
        return paper;
    }

    public int hIndex2(int[] citations) {
        Arrays.sort(citations);
        int i = 0;
        int hIndex = 0;
        int length = citations.length;
        while (i < length) {
            hIndex = Math.max(hIndex, Math.min(citations[i], length - i));
            i++;
        }
        return hIndex;
    }

    public static void main(String[] args) {
        HIndex test = new HIndex();
        int[] citations = {3, 0, 6, 1, 5};
        System.out.println(test.hIndex(citations));
    }
}