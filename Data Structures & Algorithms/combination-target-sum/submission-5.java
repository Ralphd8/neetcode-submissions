class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public void helper(int[] nums,int target,int index,List<Integer> arr,int sum){
        if(index >= nums.length){return;}
        
        if(sum == target){
            res.add(arr);
            return;
        }
        else if(sum > target){
            return;
        }
        else{
            List<Integer> arr1 = new ArrayList<>(arr);
            List<Integer> arr2 = new ArrayList<>(arr);
            arr2.add(nums[index]);
            helper(nums,target,index+1,arr1,sum);
            helper(nums,target,index,arr2,sum+nums[index]);
        }
    }
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        helper(nums,target,0,new ArrayList<Integer>(),0);
        return res;
    }
}
