class ImplementQueueUsingStack {
    private Stack<Integer> stack1;

    private Stack<Integer> stack2;

    ImplementQueueUsingStack() {
        this.stack1 = new Stack<>();
        this.stack2 = new Stack<>();
    }
    // Push element x to the back of queue.
    public void push(int x) {
        stack1.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        if (!stack2.empty()) {
            stack2.pop();
        } else {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
            stack2.pop();
        }
        
    }

    // Get the front element.
    public int peek() {
        if (!stack2.empty()) {
            return stack2.peek();
        } else {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
            return stack2.peek();
        }
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return stack2.empty() && stack1.empty();
    }
}