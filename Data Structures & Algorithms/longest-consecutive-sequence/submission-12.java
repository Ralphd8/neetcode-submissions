class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0 || nums.length == 1){
            return nums.length;
        }
        Arrays.sort(nums);
        int res = 1;
        int count = 0;
        for(int i =0;i<nums.length;i++){
            if(i == 0){count =1;}
            else{
                if(nums[i]-nums[i-1] == 1 && i == nums.length-1){
                    count++;
                    if(count>res) res = count;
                }
                if(nums[i] == nums[i-1] && i == nums.length-1){
                    if(count>res) res = count;
                }
                else if(nums[i]-nums[i-1] == 1){
                    count++;
                }
                else if(nums[i]-nums[i-1] > 1){
                    if(count>res) res = count;
                    count =1;
                }
            }
        }
        return res;
    }
}
