public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}

public class BinaryTreePostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        List<Integer> postorder = new ArrayList<>();
        while (!stack.empty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else if (stack.peek().right != pre) {
                root = stack.peek().right;
                pre = null;
            } else {
                pre = stack.pop();
                postorder.add(pre.val);
            }
        }
        return postorder;
    }
}