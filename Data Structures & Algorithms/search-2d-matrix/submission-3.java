class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        return help(matrix,target,0,matrix.length-1);
    }
    public boolean help(int[][] matrix,int target, int start,int end) {
		if(matrix[start][0] >target || matrix[end][matrix[end].length-1] <target) {
			return false;
		}
		if(target >= matrix[start][0] && target <= matrix[start][matrix[start].length-1]) {
			return help1(matrix[start],target,0,matrix[start].length-1);
		}
		if(target >= matrix[end][0] && target <= matrix[end][matrix[end].length-1]) {
			return help1(matrix[end],target,0,matrix[end].length-1);
		}
		int mid = (start+end)/2;
		if(target >= matrix[mid][0] && target <= matrix[mid][matrix[mid].length-1]) {
			return help1(matrix[mid],target,0,matrix[mid].length-1);
		}
		if(end-start ==1 || end-start == 2) {
			return false;
		}
		if(target> matrix[start][matrix[start].length-1] && target < matrix[mid][0]) {
			return help(matrix,target,start,mid);
		}
		if(target> matrix[mid][matrix[mid].length-1] && target < matrix[end][0]) {
			return help(matrix,target,mid,end);
		}
		return false;
		
		
		
		
	}
	
	public boolean help1 (int[] nums,int target,int start,int end) {
		if(target<nums[start] || target > nums[end]) {
        	return false;
        }
		if(target== nums[start]) {
			return true;
		}
		if(target == nums[end]) {
			return true;
		}
		int mid = (start+end)/2;
		if(target == nums[mid]) {
			return true;
		}
		if(end-start == 1 || end-start ==2) {
			return false;
		}
		if(target > nums[start] && target < nums[mid]) {
			return help1(nums,target,start,mid);
		}
		if(target < nums[end] && target > nums[mid]) {
			return help1(nums,target,mid,end);
		}
		return false;
	}
}
