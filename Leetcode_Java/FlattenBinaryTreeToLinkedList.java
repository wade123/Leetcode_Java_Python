import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
 }

public class FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        while (!stack.empty() || p != null) {
            if (p.right != null) {
                stack.push(p.right);
            }
            if (p.left != null) {
                p.right = p.left;
                p.left = null;
            } else if (!stack.empty()) {
                p.right = stack.pop();
            }
            p = p.right;
        }
    }

    public void flatten2(TreeNode root) {
        flattenHelper(root);
    }

    private TreeNode flattenHelper(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode left = flattenHelper(root.left);
        TreeNode right = flattenHelper(root.right);
        TreeNode p = left;
        if (p == null) {
            root.right = right;
            return root;
        }
        while (p != null && p.right != null) {
            p = p.right;
        }
        p.right = right;
        root.right = left;
        root.left = null;
        return root;
    }

    public static void main(String[] args) {
        FlattenBinaryTreeToLinkedList test = new FlattenBinaryTreeToLinkedList();
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        one.left = two;
        one.right = three;
        TreeNode root = test.flattenHelper(one);
        while (root != null) {
            System.out.println(root.val);
            root = root.right;
        }
    }
}