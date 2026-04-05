class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> inter = new Stack<>();
        for (int i = temperatures.length-1 ; i>=0 ;i--) {
        	stack.push(temperatures[i]);
        }
        for(int i = 0 ;i<temperatures.length-1;i++) {
        	stack.pop();
        	int count = 0;
        	while(stack.size() != 0) {
        		if(stack.peek() > temperatures[i]) {
        			res[i] = count+1;
        			while(inter.size() != 0) {
        				stack.push(inter.pop());
        			}
        			break;
        		}
        		inter.push(stack.pop());
        		count++;
        		if(stack.size() == 0) {
        			res[i] = 0;
        			while(inter.size() != 0) {
        				stack.push(inter.pop());
        			}
        			break;
        		}
        	}
        }
        res[res.length-1] = 0;
        return res;
    }
}
