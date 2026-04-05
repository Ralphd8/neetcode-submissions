class Solution {
    public static int intermediate(int[] nums , int target,int start,int end) {
		int size = end-start+1;
		
		if(target > nums[end] || target < nums[start]) {
			return -1;
		}
		
		if(nums[(start+end) / 2] == target) {
			return (start+end)/2;
		}
		else if(target < nums[(start+end) / 2]) {
			return intermediate(nums,target,0,(start+end)/2 -1);
		}
		else {
			return intermediate(nums,target,(start+end)/2 +1,end);
		}
	}
	public static int search(int[] nums, int target) {
        return intermediate(nums,target,0,nums.length-1);
    }
	
	public boolean helper(int[][] matrix,int target, int startLine, int endLine) {
		if(target < matrix[startLine][0] || target > matrix[endLine][matrix[0].length-1]) {
			return false;
		}
		if(target >= matrix[(startLine+endLine)/2][0] && target <= matrix[(startLine+endLine)/2][matrix[0].length-1]) {
			int res = search(matrix[(startLine+endLine)/2],target);
			if(res == -1) {
				return false;
			}
			else {
				return true;
			}
		}
		else if(target < matrix[(startLine+endLine)/2][0]) {
			return helper(matrix,target,0,(startLine+endLine)/2 -1);
		}
		else {
			return helper(matrix,target,(startLine+endLine)/2 +1,endLine);
		}
		
		
	}
	public boolean searchMatrix(int[][] matrix, int target) {
        return helper(matrix,target,0,matrix.length-1);
    }
        
    
}
