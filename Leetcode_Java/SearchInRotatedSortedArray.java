public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        if (start == end) {
            return nums[start] == target ? start : -1;
        }
        if (nums[start] < nums[end]) {
            return binarySearch(nums, start, end, target);
        }
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < nums[end]) {
                end = mid;
            } else {
                start = mid;
            }
        }
        int pivotIndex = nums[start] < nums[end] ? start : end;
        if (target >= nums[pivotIndex] && target <= nums[nums.length - 1]) {
            return binarySearch(nums, pivotIndex, nums.length - 1, target);
        } else if (target >= nums[0] && target <= nums[pivotIndex - 1]) {
            return binarySearch(nums, 0, pivotIndex - 1, target);
        } else {
            return -1;
        }
    }

    public int binarySearch(int[] nums, int start, int end, int target) {
        if (start > end) {
            return - 1;
        }
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        SearchInRotatedSortedArray test = new SearchInRotatedSortedArray();
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 7;
        System.out.println(test.search(nums, target));
    }
}