class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        for(int i=0 ;i<temperatures.length-1;i++) {
        	int qty = 0;
        		for(int j = i+1;j<temperatures.length;j++) {
        			if(temperatures[j] <= temperatures[i] && j == temperatures.length-1) {
        				qty =0;
        			}
                    else if(temperatures[j] <= temperatures[i]){
                        qty++;
                    }
        			else {
                        qty++;
        				break;
        			}
        		}
                
        		res[i] = qty;
        	
        }
        
        return res;
    }
}
