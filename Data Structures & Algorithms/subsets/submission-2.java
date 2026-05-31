class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        res.add(new ArrayList<Integer>());
        for(int i : nums){
            int size = res.size();
            for(int j=0;j<size;j++){
                List<Integer> cur = new ArrayList<>(res.get(j));
                cur.add(i);
                res.add(cur);
            }
        }
        return res;
    }
}
