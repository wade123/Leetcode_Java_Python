/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class IntersectionOfTwoLinkedList {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = getLinkedListLength(headA);
        int lenB = getLinkedListLength(headB);
        ListNode p = headA;
        ListNode q = headB;
        int diff = Math.abs(lenA - lenB);
        while (diff > 0) {
            if (lenA > lenB) p = p.next;
            else q = q.next;
            diff--;
        }
        while (p != null && q != null) {
            if (p == q) {
                return p;
            }
            p = p.next;
            q = q.next;
        }
        return null;
    }

    public int getLinkedListLength(ListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }
}