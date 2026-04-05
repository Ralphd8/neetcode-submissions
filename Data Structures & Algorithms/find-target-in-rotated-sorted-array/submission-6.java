class Solution {
    public int search(int[] nums, int target) {
        int minIndex = intermediate(nums,0,nums.length-1);
        if(minIndex == 0 && target>= nums[minIndex] && target <= nums[nums.length-1]){
            return intermediate2(nums,target,minIndex,nums.length-1);
        }
        else if(minIndex != 0){
            if(target >= nums[0] && target <= nums[minIndex-1]){
                return intermediate2(nums,target,0,minIndex-1);
            }
            else if(target>= nums[minIndex] && target <= nums[nums.length-1]){
                return intermediate2(nums,target,minIndex,nums.length-1);
            }
            else{
                return -1;
            }
        }
        else{
            return -1;
        }

    }
    public int intermediate(int[] nums,int start,int end){
        if(nums[0] <= nums[nums.length-1]){
            return 0;
        }
        int mid = (start+end) / 2;
        if(nums[mid] <= nums[start] && nums[mid] <= nums[end]){
            if(nums[mid-1] >= nums[mid]){
                return mid;
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
    public int intermediate2(int[] nums, int target,int start,int end){
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
            return intermediate2(nums,target,start,mid-1);
        }
        else{
            return intermediate2(nums,target,mid+1,end);
        }
    }
}
