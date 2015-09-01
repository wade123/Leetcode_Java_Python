class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p = dummy;
        while (p.next != null && p.next.next != null) {
            ListNode q = p.next;
            p.next = q.next;
            q.next = q.next.next;
            p.next.next = q;
            p = q;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        SwapNodesInPairs test = new SwapNodesInPairs();
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        one.next = two;
        two.next = three;
        three.next = four;
        ListNode out = test.swapPairs(three);
        while (out != null) {
            System.out.println(out.val);
            out = out.next;
        }
    }
}