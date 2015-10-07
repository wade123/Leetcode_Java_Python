public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length = nums1.length + nums2.length;
        if (length % 2 == 1) {
            return findKthElement(nums1, 0, nums1.length - 1,
                nums2, 0, nums2.length - 1, length / 2 + 1);
        } else {
            return (findKthElement(nums1, 0, nums1.length - 1, nums2, 0,
                nums2.length - 1, length / 2) + findKthElement(nums1,
                0, nums1.length - 1, nums2, 0, nums2.length - 1, length / 2 + 1)) / 2.0;
        }
    }

    private int findKthElement(int[] nums1, int oneStart, int oneEnd,
        int[] nums2, int twoStart, int twoEnd, int k) {
        int len1 = oneEnd - oneStart + 1;
        int len2 = twoEnd - twoStart + 1;
        if (len1 < len2) {
            return findKthElement(nums2, twoStart, twoEnd, nums1, oneStart, oneEnd, k);
        }
        if (len2 == 0) { // this case should be dealt before case 2
                         // to avoid ArrayIndexOutOfBoundsException
            return nums1[oneStart + k - 1];
        }
        if (k == 1) { // case 2
            return Math.min(nums1[oneStart], nums2[twoStart]);
        }
        int mid2 = Math.min(k / 2, len2);
        int mid1 = k - mid2;
        if (nums1[oneStart + mid1 - 1] > nums2[twoStart + mid2 - 1]) {
            return findKthElement(nums1, oneStart, oneEnd, nums2,
                twoStart + mid2, twoEnd, k - mid2);
        } else {
            return findKthElement(nums1, oneStart + mid1, oneEnd, nums2,
                twoStart, twoEnd, k - mid1);
        }
    }

    public static void main(String[] args) {
        MedianOfTwoSortedArrays test = new MedianOfTwoSortedArrays();
        int[] nums1 = {1};
        int[] nums2 = {3, 4};
        System.out.println(test.findMedianSortedArrays(nums1, nums2));
    }
}