class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length == 0 || prices.length ==1){
            return 0;
        }
        int max = 0;
        int left = 0;
        int right = 1;
        while(right != prices.length){
            if(prices[left] >= prices[right]){
                left = right;
                right++;
            }
            else{
                max = (int) Math.max(max,prices[right] - prices[left]);
                right++;
            }
        }
        return max;
    }
}
