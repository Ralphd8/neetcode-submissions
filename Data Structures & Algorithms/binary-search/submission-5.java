class Solution {
    public int inter(int[] nums, int target,int start,int end){
        if(start>end){
            return -1;
        }
        int mid = (end-start)/2 + start;
        if(nums[mid] != target && start==end){
            return -1;
        }
        else if(nums[mid] == target){
            return mid;
        }
        else if(nums[mid]>target){
            return inter(nums,target,start,mid-1);
        }
        else{
            return inter(nums,target,mid+1,end);
        }
    }
    public int search(int[] nums, int target) {
        return inter(nums,target,0,nums.length-1);
    }
}
