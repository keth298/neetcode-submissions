class MinStack {
    public Deque<Integer> minStack;
    public Deque<Integer> prefixStack;
    public int min;

    public MinStack() {
        minStack = new ArrayDeque<>();
        prefixStack = new ArrayDeque<>();
    }
    
    public void push(int val) {
        int currentMin = prefixStack.isEmpty() ? val : Math.min(prefixStack.peek(), val);
        prefixStack.push(currentMin);
        minStack.push(val);
    }
    
    public void pop() {
        if(!minStack.isEmpty()) minStack.pop();
        if(!prefixStack.isEmpty()) prefixStack.pop();
    }
    
    public int top() {
        return minStack.peek();
    }
    
    public int getMin() {
        return prefixStack.peek();
    }
}
