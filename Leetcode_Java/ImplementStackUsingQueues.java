class ImplementStackUsingQueues {
    private Queue<Integer> queue1;

    private Queue<Integer> queue2;

    ImplementStackUsingQueues() {
        this.queue1 = new LinkedList<>();
        this.queue2 = new LinkedList<>();
    }

    // Push element x onto stack.
    public void push(int x) {
        queue1.offer(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        int size = queue1.size();
        for (int i = 0; i < size - 1; i++) {
            queue2.offer(queue1.poll());
        }
        queue1.poll();
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }

    // Get the top element.
    public int top() {
        int size = queue1.size();
        for (int i = 0; i < size - 1; i++) {
            queue2.offer(queue1.poll());
        }
        int out = queue1.poll();
        queue2.offer(out);
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
        return out;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return queue1.isEmpty();
    }
}