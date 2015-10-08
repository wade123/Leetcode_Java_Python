class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        this.val = x;
    }
}

public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        while (pre.next != null && pre.next.val < x) {
            pre = pre.next;
        }
        ListNode cur = pre;
        while (cur.next != null && cur.next.val >= x) {
            cur = cur.next;
            while (cur.next != null && cur.next.val < x) {
                ListNode temp = cur.next;
                cur.next = cur.next.next;
                temp.next = pre.next;
                pre.next = temp;
                pre = pre.next;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        PartitionList test = new PartitionList();
        ListNode[] list = new ListNode[3];
        int[] values = {3, 1, 2};
        for (int i = 0; i < 3; i++) {
            list[i] = new ListNode(values[i]);
            if (i != 0) {
                list[i - 1].next = list[i];
            }
        }
        ListNode head = test.partition(list[0], 3);
        while (head != null) {
            System.out.print(head.val + ", ");
            head = head.next;
        }
    }
}