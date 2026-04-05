class Solution {
    public int search(int[] nums, int target) {
        return help(nums,target,0,nums.length-1);
    }
    public static int help (int[] nums,int target,int start,int end) {
		if(target<nums[start] || target > nums[end]) {
        	return -1;
        }
		if(target== nums[start]) {
			return start;
		}
		if(target == nums[end]) {
			return end;
		}
		int mid = (start+end)/2;
		if(target == nums[mid]) {
			return mid;
		}
		if(end-start == 1 || end-start ==2) {
			return -1;
		}
		if(target > nums[start] && target < nums[mid]) {
			return help(nums,target,start,mid);
		}
		if(target < nums[end] && target > nums[mid]) {
			return help(nums,target,mid,end);
		}
		return -1;
	}

}
