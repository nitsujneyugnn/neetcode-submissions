class MinStack {
    // Have a Stack Object
    // Have a variable that caches the min
    // Consider case when stack is first initialized
    // Update min when we go about operations

    private Stack<Integer> min;
    private Stack<Integer> stack;

    public MinStack() {
        stack = new Stack<>();
        min = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);
        if (min.isEmpty() || val <= min.peek()) {
            min.push(val);
        }
    }
    
    public void pop() {
        int val = stack.pop();
        if (val == min.peek()) {
            min.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min.peek();
    }
}
