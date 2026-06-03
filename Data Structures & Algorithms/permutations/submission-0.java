class Solution {
    public void helper(List<List<Integer>> res,List<Integer> arr,List<Integer> rem){
        if(rem.isEmpty()){
            res.add(arr);
            return;
        }
        for(int i =0;i<rem.size();i++){
            List<Integer> array = new ArrayList<>(arr);
            List<Integer> remaining = new ArrayList<>(rem);

            array.add(rem.get(i));
            remaining.remove(i);
            helper(res,array,remaining);
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        
        List<Integer> numsList = new ArrayList<>();
        for (int num : nums) {
            numsList.add(num);
        }
        
        helper(res, new ArrayList<Integer>(), numsList);
        return res;
    
    }
}
