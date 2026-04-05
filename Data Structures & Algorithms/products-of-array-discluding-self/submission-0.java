class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int prod = 1;
        for(int i = 0;i<nums.length;i++) {
        	for (int j =0 ;j<nums.length;j++) {
        		if(j != i) {
        			prod = prod * nums[j];
        		}
        	}
        	res[i] = prod;
        	prod = 1;
        }
        return res;
    }
}  
