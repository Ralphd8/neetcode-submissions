class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> counter = new HashSet<>();
        for (int i = 0;i<= nums.length -1 ;i++){
            counter.add(nums[i]);
        }
        boolean result = (counter.size() == nums.length) ? false : true;
        return result;
    }
}