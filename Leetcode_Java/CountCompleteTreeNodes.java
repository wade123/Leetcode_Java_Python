/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class CountCompleteTreeNodes {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        TreeNode p = root;
        int heightLeft = 0;
        while (p != null) {
            p = p.left;
            heightLeft++;
        }
        TreeNode q = root;
        int heightRight = 0;
        while (q != null) {
            q = q.right;
            heightRight++;
        }
        if (heightLeft == heightRight) {
            return (2 << (heightLeft - 1)) - 1;
        } else {
            return 1 + countNodes(root.left) + countNodes(root.right);
        }
    }
}