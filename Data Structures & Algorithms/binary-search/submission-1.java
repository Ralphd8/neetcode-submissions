class Solution {
    public int intermediate(int[] nums , int target,int start,int end) {
		int size = end-start+1;
		
		if(target > nums[end] || target < nums[start]) {
			return -1;
		}
		
		if(nums[(start+end) / 2] == target) {
			return (start+end)/2;
		}
		else if(target < nums[(start+end) / 2]) {
			return intermediate(nums,target,0,(start+end)/2 -1);
		}
		else {
			return intermediate(nums,target,(start+end)/2 +1,end);
		}
	}
    public int search(int[] nums, int target) {
        return intermediate(nums,target,0,nums.length-1);
    }
}
