public class ExcelSheetColumnNumber {
    public int titleToNumber(String s) {
    	int result = 0;
	    for (int i = 0; i < s.length(); i++) {
	    	int n = s.charAt(i) - 'A' + 1;
	    	result = result * 26 + n;
	    }
	    return result;
	}

	public static void main(String[] args) {
		ExcelSheetColumnNumber test = new ExcelSheetColumnNumber();
		String s = "AA";
		System.out.println(test.titleToNumber(s));
		System.out.println(Character.getNumericValue('A'));
	}
}