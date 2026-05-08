class MinStack {
    List<Integer> arr = new ArrayList<>();
    int min = Integer.MAX_VALUE;
    public MinStack() {
        
    }
    
    public void push(int val) {
        arr.add(val);
        if(val < min){
            min = val;
        }
    }
    
    public void pop() {
        int top = arr.remove(arr.size()-1);
        if(top == min){
            min = Integer.MAX_VALUE;
            for(Integer i : arr){
                if(i < min){
                    min = i;
                }
            }
        }
    }
    
    public int top() {
        return arr.get(arr.size()-1);
    }
    
    public int getMin() {
        return min;
    }
}
