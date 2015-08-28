import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}

public class BinaryTreePaths {
    private List<String> result = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return result;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(root.val);
        binaryTreePathsHelper(root, sb);
        return result;
    }

    public void binaryTreePathsHelper(TreeNode root, StringBuilder sb) {
        if (root.left == null && root.right == null) {
            result.add(sb.toString());
            return;
        }
        if (root.left != null) {
            StringBuilder temp = new StringBuilder(sb);
            binaryTreePathsHelper(root.left, temp.append("->" + root.left.val));
        }
        if (root.right != null) {
            StringBuilder temp = new StringBuilder(sb);
            binaryTreePathsHelper(root.right, temp.append("->" + root.right.val));
        }
    }

    public static void main(String[] args) {
        BinaryTreePaths test = new BinaryTreePaths();
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        one.left = two;
        one.right = three;
        System.out.println(test.binaryTreePaths(one));
    }
}