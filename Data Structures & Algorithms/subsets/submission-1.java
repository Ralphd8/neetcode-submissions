class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        res.add(l);
        inter(nums,0,res);
        return res;
    }
    public void inter(int[] nums,int index,List<List<Integer>> arr){
        if(index == nums.length){return;}
        List<List<Integer>> inter = new ArrayList<>();
        for(List<Integer> l : arr){
            List<Integer> newL = new ArrayList<>(l);
            newL.add(nums[index]);
            inter.add(newL);
        }
        for(List<Integer> l : inter){
            arr.add(l);
        }
        inter(nums,index+1,arr);
    }
}
