class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> stack2;
    private int min;

    public MinStack() {
        stack = new Stack<>();
        stack2 = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);
        if (stack2.isEmpty() || stack2.peek() >= val) {
            stack2.push(val);
        } 
    }
    
    public void pop() {
        int val = stack.pop();
        if (val == stack2.peek()) {
            stack2.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return stack2.peek();
    }
}
