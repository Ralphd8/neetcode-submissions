class Solution {
    public boolean isValid(String s) {
        if(s.length() == 0) return true;  
        if(s.length()%2 == 1) return false;

        Deque<Character> dq = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if((c == '}' || c == ')' || c == ']') && dq.isEmpty()){return false;}
            else if(c == '(' || c == '[' || c == '{'){dq.addFirst(c);}
            else if((c == '}' && dq.peekFirst() == '{') || 
                    (c == ']' && dq.peekFirst() == '[') || 
                    (c == ')' && dq.peekFirst() == '(')
                    ){
                        dq.removeFirst();
                    }
            else{return false;}
        }
        if(dq.isEmpty()) return true;
        return false;
    }
}
