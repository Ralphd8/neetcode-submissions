class MinStack {
    ArrayList<Integer> array;
    public MinStack() {
        array = new ArrayList<>();
    }
    
    public void push(int val) {
        array.add(val);
    }
    
    public void pop() {
        array.remove(array.size()-1);
    }
    
    public int top() {
        return array.get(array.size()-1);
    }
    
    public int getMin() {
        int min = array.get(0);
        for (Integer i : array){
            if(i<min){
                min = i;
            }
        }
        return min;
    }
}
