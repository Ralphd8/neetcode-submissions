class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> arr = new ArrayList<>();
        backtrack(candidates,target,0,res,arr);
        return res;
    }
    public void backtrack(int[] nums,int target,int index,List<List<Integer>> res,List<Integer> arr){
        if(target == 0){
            res.add(new ArrayList<>(arr));
            return;
        }
        for(int i = index;i<nums.length;i++){
            if(i> index && nums[i] == nums[i-1]){continue;}
            if(nums[i]> target){break;}
            arr.add(nums[i]);
            backtrack(nums,target-nums[i],i+1,res,arr);
            arr.remove(arr.size()-1);
        }
    }
}
