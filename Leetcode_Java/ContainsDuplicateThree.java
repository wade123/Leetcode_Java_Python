public class ContainsDuplicateThree {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            int number = nums[i];
            if (set.ceiling(number) != null && set.ceiling(number) - number <= t
                || set.floor(number) != null && number <= t + set.floor(number)) {
                return true;
            }
            set.add(number);
            if (i >= k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }
}