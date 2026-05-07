class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int[] arr = new int[nums.length];

        res[0] = 1;
        for(int i=1;i<res.length;i++){
            res[i] = res[i-1] * nums[i-1];
        }
        arr[arr.length-1] = 1;
        for(int i=arr.length-2;i>=0;i--){
            arr[i] = arr[i+1] * nums[i+1];
        }
        for(int i=0;i<nums.length;i++){
            res[i] = res[i] * arr[i];
        }
        return res;

    }
}  
