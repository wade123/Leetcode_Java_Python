/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class SumRootToLeafNumbers {
    private int sumTotal = 0;

    public int sumNumbers(TreeNode root) {
        sumNumbersHelper(root, 0);
        return sumTotal;  
    }

    private void sumNumbersHelper(TreeNode root, int curSum) {
        if (root == null) {
            return;
        }
        curSum = curSum * 10 + root.val;
        if (root.left == null && root.right == null) {
            sumTotal += curSum;
            return;
        }
        sumNumbersHelper(root.left, curSum);
        sumNumbersHelper(root.right, curSum);
    }
}