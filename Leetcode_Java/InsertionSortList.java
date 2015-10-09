class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        this.val = x;
    }
}

public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        while (cur.next != null) {
            while (cur.next != null && cur.val <= cur.next.val) {
                cur = cur.next;    
            }
            while (cur.next != null && cur.val > cur.next.val) {
                ListNode temp = cur.next;
                cur.next = cur.next.next;
                while (pre.next.val < temp.val) {
                    pre = pre.next;
                }
                temp.next = pre.next;
                pre.next = temp;
                pre = dummy;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        InsertionSortList test = new InsertionSortList();
        ListNode[] list = new ListNode[7];
        int[] values = {3, 1, 2, 6, 0, 4, 5};
        for (int i = 0; i < 7; i++) {
            list[i] = new ListNode(values[i]);
            if (i != 0) {
                list[i - 1].next = list[i];
            }
        }
        ListNode head = test.insertionSortList(list[0]);
        while (head != null) {
            System.out.print(head.val + ", ");
            head = head.next;
        }
    }
}