class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> dq = new ArrayDeque<>();
        for(String c : tokens){
            if(c.equals("*") || c.equals("+") || c.equals("-") || c.equals("/")){
                int first = dq.pop();
                int second = dq.pop();
                int newItem = (c.equals("*")) ? first * second : (c.equals("/")) ? second / first : (c.equals("+")) ? first + second : second - first;
                dq.push(newItem);
            }
            else{
                dq.push(Integer.valueOf(c));
            }
        }
        return dq.peek();
    }
}
