/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
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
// bottom-up: O(n) time, O(log(n)) space
    private ListNode list;

    public TreeNode sortedListToBST(ListNode head) {
        int length = 0;
        ListNode p = head;
        while (p != null) {
            p = p.next;
            length++;
        }
        list = head;
        return sortedListToBSTHelper(0, length - 1);
    }

    private TreeNode sortedListToBSTHelper(int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = start + (end - start) / 2;
        TreeNode left = sortedListToBSTHelper(start, mid - 1);
        TreeNode root = new TreeNode(list.val);
        root.left = left;
        list = list.next;
        root.right = sortedListToBSTHelper(mid + 1, end);
        return root;
    }
// top-down: O(n * log(n)) time, O(log(n)) space
    public TreeNode sortedListToBST(ListNode head) {
    	if (head == null) {
    		return null;
    	} else if (head.next == null) {
    		return new TreeNode(head.val);
    	}
    	ListNode fast = head.next;
    	ListNode slow = head;
    	while (fast.next != null && fast.next.next != null) {
    		fast = fast.next.next;
    		slow = slow.next;
    	}
    	TreeNode root = new TreeNode(slow.next.val);
    	ListNode rightHead = slow.next.next;
    	slow.next = null;
    	TreeNode left = sortedListToBST(head);
    	TreeNode right = sortedListToBST(rightHead);
    	root.left = left;
    	root.right = right;
    	return root;
    }
}