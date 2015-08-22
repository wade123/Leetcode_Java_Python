/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
    	return sortedArrayToBSTHelper(nums, 0, nums.length - 1);
    }

    private TreeNode sortedArrayToBSTHelper(int[] nums, int start, int end) {
    	if (start > end) {
    		return null;
    	}
    	int mid = start + (end - start) / 2;
    	TreeNode root = new TreeNode(nums[mid]);
    	TreeNode left = sortedArrayToBSTHelper(nums, start, mid - 1);
    	TreeNode right = sortedArrayToBSTHelper(nums, mid + 1, end);
    	root.left = left;
    	root.right = right;
    	return root;
    }
}