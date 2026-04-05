class Solution {
    public int find(int[] nums,int start,int end){
        if(nums[start]<nums[end] || start==end){
            return nums[start];
        }
        if(end-start == 1){
            return Math.min(nums[start],nums[end]);
        }
        int mid = (start+end)/2;
        if(nums[start]<nums[mid]){
            return find(nums,mid+1,end);
        }
        else{
            return find(nums,start,mid);
        }

    }
    public int findMin(int[] nums) {
        return find(nums,0,nums.length-1);
    }
}
