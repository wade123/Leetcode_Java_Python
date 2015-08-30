/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class RemoveDuplicatesFromSortedListTwo {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p = dummy;
        while (p != null && p.next != null) {
            ListNode q = p.next;
            while (q.next != null && q.val == q.next.val) {
                q = q.next;
            }
            if (q == p.next) {
                p = p.next;
            } else {
                p.next = q.next;
            }
        }
        return dummy.next;
    }
}