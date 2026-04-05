class Solution {
    public static boolean searchArray(int[] arr,int target,int start,int end){
        int mid = (end-start)/2 + start;
        if(start>end){
            return false;
        }
        else if(start==end && arr[start]!=target){
            return false;
        }
        else if(arr[mid] == target){
        	return true;
        }
        else if(arr[mid]>target){
            return searchArray(arr,target,start,mid-1);
        }
        else{
            return searchArray(arr,target,mid+1,end);
        }
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        for(int[] arr : matrix){
            boolean res = searchArray(arr,target,0,arr.length-1);
            if(res == true){
                return res;
            }
        }
        return false;
    }
}

