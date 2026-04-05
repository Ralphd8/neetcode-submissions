class MinStack {
    Stack<Integer> stack;
    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        if(stack.size() == 0){
            return 0;
        }
        int min = stack.peek();
        Stack<Integer> inter = new Stack<>();
        while(stack.size() != 0){
            int peek = stack.peek();
            if (peek < min){
                min = peek;
            }
            stack.pop();
            inter.push(peek);
        }
        while(inter.size() != 0){
            stack.push(inter.pop());
        }
        return min;
        
    }
}
