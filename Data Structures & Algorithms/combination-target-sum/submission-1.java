class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> arr = new ArrayList<>();
        backtrack(nums,target,0,res,arr);
        return res;
    }
    public void backtrack(int[] nums,int target,int start,List<List<Integer>> res,List<Integer> arr){
        if(target ==0){
            res.add(arr);
            return;
        }
        for(int i=start;i<nums.length;i++){
            if(nums[i] > target){continue;}
            List<Integer> inter = new ArrayList<>(arr);
            inter.add(nums[i]);
            backtrack(nums,target-nums[i],i,res,inter);
        }
    }
}
