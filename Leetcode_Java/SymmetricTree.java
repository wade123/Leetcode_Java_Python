/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class SymmetricTree {
// iterative
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> leftQueue = new LinkedList<>();
        Queue<TreeNode> rightQueue = new LinkedList<>();
        leftQueue.offer(root.left);
        rightQueue.offer(root.right);
        while (!leftQueue.isEmpty() && !rightQueue.isEmpty()) {
            TreeNode leftNode = leftQueue.poll();
            TreeNode rightNode = rightQueue.poll();
            if (leftNode == null && rightNode == null) {
                continue;
            } else if (leftNode == null || rightNode == null) {
                return false;
            } else if (leftNode.val != rightNode.val) {
                return false;
            } else {
                leftQueue.offer(leftNode.left);
                leftQueue.offer(leftNode.right);
                rightQueue.offer(rightNode.right);
                rightQueue.offer(rightNode.left);
            }
        }
        return true;
    }
// recursive
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode r1, TreeNode r2) {
        if (r1 == null && r2 == null) {
            return true;
        } else if (r1 == null || r2 == null) {
            return false;
        }
        return r1.val == r2.val && isSymmetric(r1.left, r2.right)
            && isSymmetric(r1.right, r2.left);
    }
}