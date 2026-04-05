class Solution {
    public void bubbleSort(int[] nums){
        for(int i=0;i<nums.length-1;i++){
            for(int j = 0 ; j<nums.length-1-i;j++){
                if(nums[j] > nums[j+1]){
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }
    }
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0 || nums.length == 1){
            return nums.length;
        }
        bubbleSort(nums);
        int max = 1;
        int count = 1;
        for(int i = 0; i <nums.length-1;i++){
            if(nums[i+1] == nums[i] +1){
                count++;
            }
            else if (nums[i+1] == nums[i]){
                continue;
            }
            else{
                if(count > max){
                    max = count; 
                }
                count = 1;
            }
        }
        return Math.max(count,max);
    }
}
