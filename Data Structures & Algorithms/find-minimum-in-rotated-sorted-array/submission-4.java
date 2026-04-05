class Solution {
    public int helper(int[] nums, int start , int end) {
        if(nums.length == 1) {
			return nums[0];
		}
		if(nums[start] <= nums[(start+end)/2] && nums[(start+end)/2 +1]  <= nums[end]) {
			return Math.min(nums[start], nums[(start+end)/2 +1]);
		}
		else if(nums[start] <= nums[(start+end)/2] && nums[(start+end)/2 +1] >= nums[end]) {
			return helper(nums,(start+end)/2+1,end);
		}
		else {
			return helper(nums,start,(start+end)/2);
		}
	}
	public int findMin(int[] nums) {
        return helper(nums,0,nums.length-1);
    }
}
