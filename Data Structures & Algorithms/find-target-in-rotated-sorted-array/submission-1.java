class Solution {
    public int search(int[] nums, int target) {
        return help(nums,target,0,nums.length-1);
    }
    public int help(int[] nums, int target, int start , int end) {
		int mid = (start+end)/2;
		if(start == end && target == nums[start]) {
			return start;
		}
		if(start==end && target!= nums[start]) {
			return -1;
		}
		if(end - start == 1 && target != nums[start] && target != nums[end]) {
			return -1;
		}
		if(end - start == 2 && target != nums[start] && target != nums[end] && target != nums[mid]) {
			return -1;
		}
		if(target == nums[start]) {
			return start;
		}
		if(target == nums[mid]) {
			return mid;
		}
		if(target == nums[end]) {
			return end;
		}
		if(help(nums,target,start,mid)  > -1) {
			return help(nums,target,start,mid);
		}
		return help(nums,target,mid,end);		
		
	}
}
