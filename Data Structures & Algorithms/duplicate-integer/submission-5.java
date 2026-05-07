class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(Integer i : nums){set.add(i);}
        if(set.size() == nums.length) return false;
        return true;
    }
}