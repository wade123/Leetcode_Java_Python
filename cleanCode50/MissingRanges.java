import java.util.*;

public class MissingRanges {
	public List<String> findMissingRanges(int[] values, int start, int end) {
		List<String> result = new ArrayList<>();
		if (values == null || values.length == 0) {
			result.add(start + "->" + end);
			return result;
		}
		String head = getRange(start - 1, values[0]);
		if (head != null) {
			result.add(head);
		}
		for (int i = 1; i < values.length; i++) {
			String inteval = getRange(values[i - 1], values[i]);
			if (inteval != null) {
				result.add(inteval);
			}
		}
		String tail = getRange(values[values.length - 1], end + 1);
		if (tail != null) {
			result.add(tail);
		}
		return result;
	}

	private String getRange(int left, int right) {
		if (left + 1 == right) {
			return null;
		} else if (left + 2 == right) {
			return Integer.toString(left + 1);
		} else {
			return String.valueOf(left + 1) + "->" + String.valueOf(right - 1);
		}
	}

	public static void main(String[] args) {
		MissingRanges test = new MissingRanges();
		int[] values = {0, 1, 3, 50, 75};
		System.out.println(test.findMissingRanges(values, 0, 99));
	}
}