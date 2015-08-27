public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        for (int number : nums) {
            if (number == val) {
                continue;
            } else {
                nums[i] = number;
                i++;
            }
        }
        return i;
    }
}