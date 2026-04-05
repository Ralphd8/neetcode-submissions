class MinStack {
    Stack<Integer> stack;
    int min = Integer.MIN_VALUE;
    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int val) {
        if(stack.size() == 0){
            min = val;
        }
        else{
            if(val < min){
                min = val;
            }
        }
        stack.push(val);
    }
    
    public void pop() {
        if(stack.peek() == min && stack.size() == 1){
            stack.pop();
            min = Integer.MIN_VALUE;
        }
        else if(stack.peek() == min){
            stack.pop();
            int newMin = stack.peek();
            for (Integer i : stack) {
                if(i < newMin){
                    newMin = i;
                }
            }
            min = newMin;
        }
        else{
            stack.pop();
        }   
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min;
    }
}
