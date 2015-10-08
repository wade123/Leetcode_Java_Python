/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class MergeKSortedList {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        int length = lists.length;
        Queue<ListNode> queue = new PriorityQueue<>(
            new Comparator<ListNode>() {
                @Override
                public int compare(ListNode a, ListNode b) {
                    return a.val - b.val;
                }
            });
        for (ListNode node : lists) {
            if (node != null) {
                queue.offer(node);
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            p.next = node;
            p = p.next;
            if (node.next != null) {
                queue.offer(node.next);
            }
        }
        return dummy.next;
    }

    public ListNode mergeKLists2(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        int length = lists.length;
        while (length > 1) {
            int count = 0;
            int i = 0;
            for (; i < length - 1; i += 2) {
                lists[count++] = mergeTwoLists(lists[i], lists[i + 1]);
            }
            if (2 * count + 1 == length) {
                lists[count++] = lists[i];
            }
            length = count;
        }
        return lists[0];
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
}