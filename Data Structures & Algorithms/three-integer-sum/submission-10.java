class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
         List<List<Integer>> res = new ArrayList<>();
         Arrays.sort(nums);
         for(int i=0;i<nums.length;i++){
            int left = 0;
            int right = nums.length-1;
            int target = -nums[i];
            while(left < right){
                int sum = nums[left] + nums[right];
                if(left == i){
                    left++;
                }
                else if(right == i){
                    right--;
                }
                else if(sum > target){
                    right--;
                }
                else if(sum < target){
                    left++;
                }
                else{
                    List<Integer> arr = new ArrayList<>(List.of(nums[i],nums[left],nums[right]));
                    Collections.sort(arr);
                    if(!res.contains(arr)){
                        res.add(arr);
                    }
                    left++;
                }
            }
         }
         
         return res;
    }
}
