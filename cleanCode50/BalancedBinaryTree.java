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
    public boolean isBalanced(TreeNode root) {
        return maxDepth(root) != -1;
    }

    private int maxDepth(TreeNode root) {
    	if (root == null) {
    		return 0;
    	}
    	int leftDepth = maxDepth(root.left);
    	if (leftDepth == -1) {
    		return -1;
    	}
    	int rightDepth = maxDepth(root.right);
    	if (rightDepth == -1) {
    		return -1;
    	}
    	if (Math.abs(leftDepth - rightDepth) <= 1) {
    		return 1 + Math.max(leftDepth, rightDepth);
    	} else {
    		return -1;
    	}
    }
}