import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int number : nums) {
            if (set.contains(number)) {
                return true;
            }
            set.add(number);
        }
        return false;
    }

    public static void main(String[] args) {
        ContainsDuplicate test = new ContainsDuplicate();
        int[] nums = {1, 2, 3, 4, 5, 5};
        System.out.println(test.containsDuplicate(nums));
    }
}