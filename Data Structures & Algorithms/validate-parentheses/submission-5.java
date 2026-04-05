class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0;i<s.length();i++){
            char cur = s.charAt(i);
            if (stack.isEmpty() && (cur == '}' || cur == ')' || cur == ']')){
                return false;
            }
            else if(cur == '(' || cur == '{' || cur == '['){
                stack.push(s.charAt(i));
            }
            else if((stack.peek() == '(' && cur == ')') || (stack.peek() == '{' && cur == '}') || (stack.peek() == '[' && cur == ']')){
                stack.pop();
            }
            else{
                return false;
            }
        }
        if(stack.isEmpty()){
            return true;
        }
        else{
            return false;
        }
    }
}
