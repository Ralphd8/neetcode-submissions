class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length-k+1];
        int a = 0 ;
        int b = a+k-1;
        for(int i =0;i<res.length;i++) {
        	int max = nums[a];
        	while(b != a) {
        		if(nums[b] > max) {
        			max = nums[b];
        		}
        		b--;
        	}
        	res[i] = max;
        	a++;
        	b = a+k-1;
        }
        
        return res;
    }
}
