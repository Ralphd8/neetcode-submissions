class Solution {
    public int findMin(int[] nums) {
        return help(nums,0,nums.length-1);
    }
    public int help(int[] nums,int start,int end) {
		if(start == end) {
			return nums[start];
		}
		int mid = (start + end)/2;
		if(nums[start] <= nums[mid] && nums[mid] <= nums[end]) {
			return nums[start];
		}
		else if (nums[start] <= nums[mid] && nums[mid] >= nums[end]){
			return help(nums,mid+1,end);
		}
		else if(nums[start] <= nums[mid] && nums[mid] <= nums[end] && nums[mid] <= nums[mid-1]) {
			return nums[mid];
		}
		else {
			return help(nums,start+1,mid);
		}
	}
}
