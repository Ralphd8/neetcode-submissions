class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> nums = new Stack<>();
        
        for(int i =0;i<tokens.length;i++) {
        	if(!tokens[i].equals("+") && !tokens[i].equals("-") && !tokens[i].equals("*") && !tokens[i].equals("/")) {
        		nums.push(Integer.parseInt(tokens[i]));
        	}
        	else {
        		int num1 = nums.pop();
        		int num2 = nums.pop();
        		int res = (tokens[i].equals("+")) ? (num1 + num2) : (tokens[i].equals("-")) ?  (num2 - num1) : (tokens[i].equals("*")) ? (num1 * num2) : (num2 / num1) ;
        		nums.push(res);
        	}
        }
        return nums.peek();
    }
}
