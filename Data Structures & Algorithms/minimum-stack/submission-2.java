class MinStack {

    private List<Integer> stack;
    private List<Integer> minStack;

    public MinStack() {
        stack = new ArrayList<>();
        minStack = new ArrayList<>();
    }
    
    public void push(int val) {
        stack.add(val);
        if (minStack.isEmpty() || val <= minStack.getLast()) {
            minStack.add(val);
        }
    }
    
    public void pop() {
        int top = stack.removeLast();
        if (top == minStack.getLast()) {
            minStack.removeLast();
        }
    }
    
    public int top() {
        return stack.getLast();
    }
    
    public int getMin() {
        return minStack.getLast();
    }
}
