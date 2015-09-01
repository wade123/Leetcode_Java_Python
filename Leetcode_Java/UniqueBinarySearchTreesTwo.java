/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class UniqueBinarySearchTreesTwo {
    public List<TreeNode> generateTrees(int n) {
        return generateTreesHelper(1, n);
    }

    private List<TreeNode> generateTreesHelper(int left, int right) {
        List<TreeNode> result = new ArrayList<>();
        if (left > right) {
            result.add(null);
            return result;
        }
        if (left == right) {
            result.add(new TreeNode(left));
            return result;
        }
        for (int i = left; i <= right; i++) {
            for (TreeNode leftTree : generateTreesHelper(left, i - 1)) {
                for (TreeNode rightTree : generateTreesHelper(i + 1, right)) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftTree;
                    root.right = rightTree;
                    result.add(root);
                }
            }
        }
        return result;
    }
}