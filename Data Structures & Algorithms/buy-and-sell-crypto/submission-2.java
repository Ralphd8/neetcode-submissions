class Solution {
    public int maxProfit(int[] prices) {
        HashSet<Integer> hash = new HashSet<>();
		
        if(prices.length == 0) {
        	return 0;
        }
        int i = 0;
        int j = i+1;
        int max = -1;
        int count= 0;
        int ite = 0;
        while (i <= prices.length-2) {
        	while (j <= prices.length-1) {
        		while(prices[j] >= prices[i]) {
        			if((ite > 0 && count == 0) || j == prices.length-1) {
        				break;
        			}
        			count++;
        			if(prices[j] - prices[i] > max) {
        				max = prices[j] - prices[i];
        				
        			}
        			j++;
        			ite++;
        		}
        		if(j > prices.length-1) {
        			break;
        		}
        		if(prices[j] - prices[i] > max) {
        			max = prices[j] - prices[i];
        			j++;
        		}
        		j++;
        		ite++;
        	}
        	hash.add(max);
        	count = 0;
        	i = i +count+1;
        	j= i+1;
        	ite=0;
        }
        
        int m =0 ;
        for(int k : hash) {
        	if(k> m) {
        		m = k;
        	}
        }
        return m;
    }
}
