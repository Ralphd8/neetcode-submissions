class Solution {
    public int findDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int count = 0;

        for(Integer i : nums){
            set.add(i);
            count++;
            if(count != set.size()){
                return i;
            }
        }
        return 0;
    }
}
