class Solution {
    public static int helper(int[] nums, int start , int end) {
		if(nums.length == 1) {
			return 0;
		}
		if(nums[start] <= nums[(start+end)/2] && nums[(start+end)/2 +1]  <= nums[end]) {
			if(nums[start] <= nums[(start+end)/2+1]){
				return start;
			}
			else {
				return (start+end)/2+1;
			}
		}
		else if(nums[start] <= nums[(start+end)/2] && nums[(start+end)/2 +1] >= nums[end]) {
			return helper(nums,(start+end)/2+1,end);
		}
		else {
			return helper(nums,start,(start+end)/2);
		}
	}
	public static int findMinIndex(int[] nums) {
        return helper(nums,0,nums.length-1);
    }
	
	/// correct till here
	
	public static int intermediate(int[] nums , int target,int start,int end) {
		int size = end-start+1;
		
		if(target > nums[end] || target < nums[start]) {
			return -1;
		}
		
		if(nums[(start+end) / 2] == target) {
			return (start+end)/2;
		}
		else if(nums[start] == target) {
			return start;
		}
		else if(nums[end] == end) {
			return end;
		}
		else if(target < nums[(start+end) / 2]) {
			return intermediate(nums,target,0,(start+end)/2 -1);
		}
		else {
			return intermediate(nums,target,(start+end)/2 +1,end);
		}
	}
    public static int searchTarget(int[] nums, int target) {
        return intermediate(nums,target,0,nums.length-1);
    }
	
	
	public static int search(int[] nums, int target) {
        int minIndex = findMinIndex(nums);
        //return minIndex;
        if(minIndex == 0) {
        	return searchTarget(nums,target);
        }
        else {
        	return Math.max(intermediate(nums,target,0,minIndex-1),intermediate(nums,target,minIndex,nums.length-1));
        				
        }
    }
}
