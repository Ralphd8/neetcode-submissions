class Solution {
    public boolean isValid(String s) {
        if(s.length() % 2 == 1) {
        	return false;
        }
        Stack<Character> stack = new Stack<>();
        for(int i = 0;i<s.length();i++) {
        	if(stack.size() == 0 && (s.charAt(i) == ')' || s.charAt(i) == ']' || s.charAt(i) == '}')) {
        		return false;
        	}
        	if(s.charAt(i) == '{' || s.charAt(i) == '(' || s.charAt(i) == '[') {
        		stack.push(s.charAt(i));
        		continue;
        	}
        	if( (s.charAt(i) == ')' && stack.peek() != '(') || (s.charAt(i) == ']' && stack.peek() != '[') || (s.charAt(i) == '}' && stack.peek() != '{')) {
        		return false;
        	}
        	if( (s.charAt(i) == ')' && stack.peek() == '(') || (s.charAt(i) == ']' && stack.peek() == '[') || (s.charAt(i) == '}' && stack.peek() == '{')) {
        		stack.pop();
        	}
        	
        }
        if(stack.size() == 0) {
        	return true;
        }
        else {
        	return false;
        }
    }
}
