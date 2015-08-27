public class ExcelSheetColumnTitle {
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while (n != 0) {
            n--;
            int remainder = n % 26;
            n /= 26;
            sb.append((char) (remainder + 'A'));
        }
        return sb.reverse().toString();       
    }

    public static void main(String[] args) {
        ExcelSheetColumnTitle test = new ExcelSheetColumnTitle();
        int n = 28;
        System.out.println(test.convertToTitle(n));
    }
}