class Solution {
    public int evalRPN(String[] tokens) {
        if(tokens.length ==0) {
			return 0;
		}
		Stack<String> integer = new Stack();
		
		int res = 0;
        for (int i = 0;i< tokens.length ; i++) {
        	if (!tokens[i].equals("+") && !tokens[i].equals("-") && !tokens[i].equals("*") && !tokens[i].equals("/")) {
        		integer.push(tokens[i]);
        	}
        	else {
        		String one = integer.pop();
        		String two = integer.pop();
        		if(tokens[i].equals("+")) {
            		res = Integer.parseInt(two)+ Integer.parseInt(one);
            	}
            	else if (tokens[i].equals("-")) {
            		res = Integer.parseInt(two) -  Integer.parseInt(one);
            	}
            	else if (tokens[i].equals("*")) {
            		res = Integer.parseInt(two) *  Integer.parseInt(one);
            	}
            	else {
            		res = Integer.parseInt(two) /  Integer.parseInt(one);
            	}
            	integer.push(String.valueOf(res));
        	}
        }
        return Integer.parseInt(integer.pop());
    }
}
