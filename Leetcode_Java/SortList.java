class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        this.val = x;
    }
}

public class SortList {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode headTwo = slow.next;
        slow.next = null;
        ListNode one = sortList(head);
        ListNode two = sortList(headTwo);
        return mergeTwoLists(one, two);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode dummy = new ListNode(-1);
        ListNode p = l1;
        ListNode q = l2;
        ListNode r = dummy;
        while (p != null && q != null) {
            if (p.val < q.val) {
                r.next = p;
                p = p.next;
            } else {
                r.next = q;
                q = q.next;
            }
            r = r.next;
        }
        while (p != null) {
            r.next = p;
            r = r.next;
            p = p.next;
        }
        while (q != null) {
            r.next = q;
            r = r.next;
            q = q.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        SortList test = new SortList();
        ListNode[] list = new ListNode[7];
        int[] values = {3, 1, 2, 6, 0, 4, 5};
        for (int i = 0; i < 7; i++) {
            list[i] = new ListNode(values[i]);
            if (i != 0) {
                list[i - 1].next = list[i];
            }
        }
        ListNode head = test.sortList(list[0]);
        while (head != null) {
            System.out.print(head.val + ", ");
            head = head.next;
        }
    }
}