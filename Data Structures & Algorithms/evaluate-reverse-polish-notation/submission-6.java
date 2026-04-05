class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String s : tokens){
            if (!s.equals("+") && !s.equals("-") && !s.equals("/") && !s.equals("*")){
                stack.push(Integer.parseInt(s));
            }
            else{
                int first = stack.pop();
                int second = stack.pop();
                int newest = 0;
                if(s.equals("+")){
                    newest = first+second;
                }
                else if(s.equals("-")){
                    newest = second - first;
                }
                else if(s.equals("*")){
                    newest = first * second;
                }
                else{
                    newest = second/first;
                }
                stack.push(newest);
            }
        }
        return stack.peek();
    }
}
