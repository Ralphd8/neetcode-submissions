class MinStack {
    
    Deque<Integer> q = new ArrayDeque<>();
    Deque<Integer> minStack = new ArrayDeque<>();
    public MinStack() {
        
    }
    
    public void push(int val) {
        q.push(val);
        if(minStack.isEmpty() || minStack.peek() >= val){
            minStack.push(val);
        }

    }
    
    public void pop() {
        int top = q.poll();
        if(top == minStack.peek()){
            minStack.poll();
        }
    }
    
    public int top() {
        return q.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
