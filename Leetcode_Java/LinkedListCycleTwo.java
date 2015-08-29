class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
 }

public class LinkedListCycleTwo {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
            if (fast == null || fast.next == null) {
                return null;
            }
        }
        ListNode p = head;
        while (p != null) {
            if (p == slow) {
                return p;
            }
            p = p.next;
            slow = slow.next;
        }
        return null;
    }

    public static void main(String[] args) {
        LinkedListCycleTwo test = new LinkedListCycleTwo();
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        one.next = two;
        two.next = one;
        System.out.println(test.detectCycle(one).val);
    }
}