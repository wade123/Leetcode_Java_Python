public class MajorityElement {
    public int majorityElement(int[] nums) {
        int major = nums[0];
        int count = 0;
        for (int element : nums) {
            if (count == 0) {
                major = element;
                count++;
            } else if (element == major) {
                count++;
            } else {
                count--;
            }
        }
        return major;
    }

    public static void main(String[] args) {
        MajorityElement test = new MajorityElement();
        int[] nums = {3, 3, 2};
        System.out.println(test.majorityElement(nums));
    }
}