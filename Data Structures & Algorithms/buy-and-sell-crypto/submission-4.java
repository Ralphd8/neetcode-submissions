class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;

        for(int i=0;i<prices.length-1;i++){
            int m = 0;
            for(int j =i+1;j<prices.length;j++){
                if(prices[j]>prices[i] && (prices[j]-prices[i]) > m){
                    m = prices[j]-prices[i];
                }
            }
            if (m>max){
                max=m;
            }
        }

        return max;
    }
}
