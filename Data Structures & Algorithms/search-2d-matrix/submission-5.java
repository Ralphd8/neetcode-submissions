class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        return check(matrix,target,0,matrix.length-1);
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
    public boolean check(int[][] matrix, int target,int start,int end){
        int mid = (start+end) / 2;
        if(target < matrix[start][0] || target > matrix[end][matrix[end].length-1]){
            return false;
        }
        else if(target >= matrix[mid][0] && target <= matrix[mid][matrix[mid].length-1]){
            int res = intermediate(matrix[mid],target,0,matrix[mid].length-1);
            if(res == -1){
                return false;
            }
            else{
                return true;
            }
        }
        else if(target < matrix[mid][0]){
            return check(matrix,target,0,mid-1);
        }
        else{
            return check(matrix,target,mid+1,end);
        }
    }
}
