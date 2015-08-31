import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}

public class PathSumTwo {
    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<Integer> list = new ArrayList<>();
        pathSumHelper(root, sum, list);
        return result;
    }

    private void pathSumHelper(TreeNode root, int sum, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        if (root.left == null && root.right == null && root.val == sum) {
            result.add(new ArrayList<Integer>(list));
            list.remove(list.size() - 1);
            return;
        }
        pathSumHelper(root.left, sum - root.val, list);
        pathSumHelper(root.right, sum - root.val, list);
        list.remove(list.size() - 1);
    }

    public static void main(String[] args) {
        PathSumTwo test = new PathSumTwo();
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(1);
        one.left = two;
        one.right = three;
        two.right = four;
        System.out.println(test.pathSum(one, 4));
    }
}