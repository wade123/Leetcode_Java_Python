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
	private int maxPathSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
    	singleMaxPathSum(root);
    	return maxPathSum;
    }

    private int singleMaxPathSum(TreeNode root) {
    	if (root == null) {
    		return 0;
    	}
    	int left = singleMaxPathSum(root.left);
    	int right = singleMaxPathSum(root.right);
    	int singleMax = Math.max(root.val, Math.max(left, right) + root.val);
    	maxPathSum = Math.max(maxPathSum, Math.max(singleMax, root.val + left + right));
    	return singleMax;
    }
}