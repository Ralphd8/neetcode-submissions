class MinStack {

    Stack<Integer> stack;
	public MinStack() {
        stack = new Stack();
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
    	int min = stack.peek();
    	Iterator<Integer> it = stack.iterator();
    	while (it.hasNext()) {
            int value = it.next(); 
            if (value < min) {    
                min = value;
            }
        }
        
        return min;
    	
    
    }
}
