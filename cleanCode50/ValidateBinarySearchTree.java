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
    public boolean isValidBST(TreeNode root) {
        return validBST(root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
    }
    
    private boolean validBST(TreeNode root, Double min, Double max) {
        if (root == null) {
            return true;
        } else if (root.val > min && root.val < max) {
            Double rootValue = Double.valueOf(root.val);
            return validBST(root.left, min, rootValue) && validBST(root.right, rootValue, max);
        } else {
            return false;
        }
    }
}