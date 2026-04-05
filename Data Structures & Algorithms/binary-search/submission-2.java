class Solution {
    public int search(int[] nums, int target) {
        return intermediate(nums,target,0,nums.length-1);
    }
    public int intermediate(int[] nums, int target,int start,int end){
        int mid = (start+end)/2;
        if(target < nums[start] || target > nums[end]){
            return -1;
        }
        else if(nums.length ==2 && target != nums[start] && target != nums[end]){
            return -1;
        }
        else if(target == nums[mid]){
            return mid;
        }
        else if(target < nums[mid]){
            return intermediate(nums,target,start,mid-1);
        }
        else{
            return intermediate(nums,target,mid+1,end);
        }
    }
}
