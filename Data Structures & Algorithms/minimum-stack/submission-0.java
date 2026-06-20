class MinStack {

    private List<Integer> stack;
    private Queue<Integer> minHeap;

    public MinStack() {
        stack = new ArrayList<>();
        minHeap = new PriorityQueue<>();
    }
    
    public void push(int val) {
        stack.add(val);
        minHeap.add(val);
    }
    
    public void pop() {
        int val = stack.removeLast();
        minHeap.remove(val);
    }
    
    public int top() {
        return stack.getLast();
    }
    
    public int getMin() {
        return minHeap.peek();
    }
}
