/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class KthSmallestElementInABST {
// binary search: O(log(n))/O(h)
    public int kthSmallest(TreeNode root, int k) {
        int nodesInLeft = countNodes(root.left);
        if (nodesInLeft + 1 == k) {
            return root.val;
        } else if (nodesInLeft + 1 < k) {
            return kthSmallest(root.right, k - nodesInLeft - 1);
        } else {
            return kthSmallest(root.left, k);
        }
    }

    private int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
//inorder traversal: O(n) time
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        int count = 0;
        while (!stack.empty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                count++;
                if (count == k) {
                    return root.val;
                }
                root = root.right;
            }
        }
        return -1;
    }
}