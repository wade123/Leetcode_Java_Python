import java.util.*;

public class MajorityElementTwo {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        Integer one = null;
        Integer two = null;
        int countOne = 0;
        int countTwo = 0;
        for (int element : nums) {
            if (one != null && element == one) {
                countOne++;
            } else if (two != null && element == two) {
                countTwo++;
            } else if (countOne == 0) {
                countOne = 1;
                one = element;
            } else if (countTwo == 0) {
                countTwo = 1;
                two = element;
            } else {
                countOne--;
                countTwo--;
            }
        }
        countOne = 0;
        countTwo = 0;
        for (int element : nums) {
            if (one != null && element == one) {
                countOne++;
            }
            if (two != null && element == two) {
                countTwo++;
            }
        }
        if (countOne > nums.length / 3) {
            result.add(one);
        }
        if (countTwo > nums.length / 3) {
            result.add(two);
        }
        return result;
    }

    public static void main(String[] args) {
        MajorityElementTwo test = new MajorityElementTwo();
        int[] nums = {1};
        System.out.println(test.majorityElement(nums));
    }
}