public class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minList;

    MinStack() {
        this.stack = new Stack<>();
        this.minList = new Stack<>();
        minList.push(Integer.MAX_VALUE);
    }
    
    public void push(int x) {
        stack.push(x);
        if (x <= minList.peek()) {
            minList.push(x);
        }
    }

    public void pop() {
        if (stack.peek().equals(minList.peek())) {
            minList.pop();
        }
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minList.peek();
    }
}
