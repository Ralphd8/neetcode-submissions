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
    public int find(int[] nums,int start,int end){
        if(nums[start]<nums[end] || start==end){
            return start;
        }
        if(end-start == 1){
            if(nums[start]<nums[end]){
                return start;
            }
            else{
                return end;
            }
        }
        int mid = (start+end)/2;
        if(nums[start]<nums[mid]){
            return find(nums,mid+1,end);
        }
        else{
            return find(nums,start,mid);
        }
    }
    public int search(int[] nums, int target) {
        int minIndex = find(nums,0,nums.length-1);
        if(minIndex == 0){
            return inter(nums,target,0,nums.length-1);
        }
        else if(minIndex == nums.length-1){
            if(nums[minIndex] == target){
                return minIndex;
            }
            else{
                return inter(nums,target,0,minIndex-1);
            }
        }
        else{
            return Math.max(inter(nums,target,0,minIndex),inter(nums,target,minIndex,nums.length-1));
        }
    }
}
