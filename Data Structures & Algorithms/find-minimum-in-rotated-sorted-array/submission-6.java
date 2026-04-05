class Solution {
    public int findMin(int[] nums) {
        return intermediate(nums,0,nums.length-1);
    }
    public int intermediate(int[] nums,int start,int end){
        if(nums[0] <= nums[nums.length-1]){
            return nums[0];
        }
        int mid = (start+end) / 2;
        if(nums[mid] <= nums[start] && nums[mid] <= nums[end]){
            if(nums[mid-1] >= nums[mid]){
                return nums[mid];
            }
            else{
                return intermediate(nums,start,mid-1);
            }
        }
        else if(nums[mid] >= nums[start] && nums[mid] >= nums[end]){
            return intermediate(nums,mid+1,end);
        }
        else{
            return intermediate(nums,start,mid-1);
        }
    }
}
