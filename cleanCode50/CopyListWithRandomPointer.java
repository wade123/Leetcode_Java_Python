class RandomListNode {
    int label;
    RandomListNode next;
    RandomListNode random;
    RandomListNode(int x) { 
        this.label = x; 
    }
}

public class CopyListWithRandomPointer {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return head;
        }
        RandomListNode headCopy = new RandomListNode(head.label);
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        map.put(head, headCopy);
        RandomListNode p = head;
        while (p != null && (p.next != null || p.random != null)) {
            if (p.next != null) {
                if (!map.containsKey(p.next)) {
                    RandomListNode nextNode = new RandomListNode(p.next.label);
                    map.put(p.next, nextNode);
                }
                map.get(p).next = map.get(p.next);
            }
            if (p.random != null) {
                if (!map.containsKey(p.random)) {
                    RandomListNode randomNode = new RandomListNode(p.random.label);
                    map.put(p.random, randomNode);
                }
                map.get(p).random = map.get(p.random);
            }
            p = p.next;
        }
        return headCopy;
    }
}