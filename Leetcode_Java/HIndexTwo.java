public class HIndexTwo {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }
        int length = citations.length;
        int start = 0;
        int end = length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (citations[mid] == length - mid) {
                return citations[mid];
            } else if (citations[mid] < length - mid) {
                start = mid;
            } else {
                end = mid;
            }
        }
        return Math.max(Math.min(citations[end], length - end),
            Math.min(citations[start], length - start));
    }

    public static void main(String[] args) {
        HIndexTwo test = new HIndexTwo();
        int[] citations = {0, 0, 1};
        System.out.println(test.hIndex(citations));
    }
}