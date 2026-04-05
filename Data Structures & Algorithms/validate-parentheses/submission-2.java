class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0 ;i<s.length() ;i++) {
        	if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
        		stack.push(s.charAt(i));
        		continue;
        	}
        	if(stack.size() == 0 && (s.charAt(i) == ')' || s.charAt(i) == ']' || s.charAt(i) == '}')) {
        		return false;
        	}
        	if((stack.peek() == '[' && s.charAt(i) == ']') || (stack.peek() == '(' && s.charAt(i) == ')') ||  (stack.peek() == '{' && s.charAt(i) == '}')) {
        		stack.pop();
                continue;
        	}
        	if(stack.size() != 0 && stack.peek() == '(' && (s.charAt(i) == ']' || s.charAt(i) == '}')) {
        		return false;
        	}
        	if(stack.size() != 0 && stack.peek() == '[' && (s.charAt(i) == ')' || s.charAt(i) == '}')) {
        		return false;
        	}
        	if(stack.size() != 0 && stack.peek() == '{' && (s.charAt(i) == ')' || s.charAt(i) == ']')) {
        		return false;
        	}
        	
        }
        if(stack.size()== 0) {
        	return true;
        }
        return false;
    }
}
