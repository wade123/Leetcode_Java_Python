public class SearchInRotatedSortedArrayTwo {
    public boolean search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[mid] < nums[end]) {
                if (target > nums[mid] && target <= nums[end]) {
                    start = mid;
                } else {
                    end = mid;
                }
            } else if (nums[mid] > nums[end]) {
                if (target >= nums[start] && target < nums[mid]) {
                    end = mid;
                } else {
                    start = mid;
                }
            } else {
                end--;
            }
        }
        return nums[start] == target || nums[end] == target;
    }

    public boolean search2(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        if (start == end) {
            return nums[start] == target;
        }
        if (nums[start] < nums[end]) {
            return binarySearch(nums, start, end, target);
        }
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < nums[end]) {
                end = mid;
            } else if (nums[mid] > nums[end]) {
                start = mid;
            } else {
                end--;
            }
        }
        int pivotIndex = nums[start] < nums[end] ? start : end;
        if (target >= nums[pivotIndex] && target <= nums[nums.length - 1]) {
            return binarySearch(nums, pivotIndex, nums.length - 1, target);
        } else if (target >= nums[0] && target <= nums[pivotIndex - 1]) {
            return binarySearch(nums, 0, pivotIndex - 1, target);
        } else {
            return false;
        }
    }

    public boolean binarySearch(int[] nums, int start, int end, int target) {
        if (start > end) {
            return false;
        }
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        SearchInRotatedSortedArrayTwo test = new SearchInRotatedSortedArrayTwo();
        int[] nums = {1, 1, 3, 1};
        int target = 3;
        System.out.println(test.search(nums, target));
    }
}