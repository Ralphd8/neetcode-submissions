class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> subList = new ArrayList<>();
        list.add(subList);
        for(Integer i : nums){
            List<List<Integer>> inter = new ArrayList<>(list);
            for(List<Integer> sub : inter){
                List<Integer> newList = new ArrayList<>(sub);
                newList.add(i); 
                list.add(newList);
            }
        }

        return list;
    }
}
