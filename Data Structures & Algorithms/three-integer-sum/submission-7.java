class Solution {
    public static void sort(int[] nums){
        for (int i = 0;i<nums.length -1 ;i++){
            for(int j = i+1;j<nums.length;j++){
                if(nums[j]<nums[i]){
                    int temp = nums[i];
                    nums[i]=nums[j];
                    nums[j] = temp;
                }
            }
        }
    }
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        sort(nums);
        for(int i = 0;i<nums.length-2;i++){
            if(nums[i] > 0){
                break;
            }
            for (int j = i+1;j<nums.length-1;j++){
                if(nums[i]+nums[j] > 0){
                    break;
                }
                for(int k = j+1;k<nums.length;k++){
                    if(nums[i]+nums[j]+nums[k] > 0){
                        break;
                    }
                    List<Integer> list = new ArrayList<>();
                    if(nums[i]+nums[j]+nums[k] == 0){
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        Collections.sort(list);
                        if(res.contains(list) == false){
                            res.add(list);
                        }
                    }
                }
            }
        }
        return res;
    }
}
