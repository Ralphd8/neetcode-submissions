class Solution {
    public int findDuplicate(int[] nums) {
        ArrayList<Integer> array = new ArrayList<>();

        for(int i=0 ;i<nums.length;i++){
            if(array.contains(nums[i])){
                return nums[i];
            }
            array.add(nums[i]);
        }
        return -1;
    }
}
