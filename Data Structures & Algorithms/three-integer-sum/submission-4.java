class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        HashSet<List<Integer>> hash = new HashSet<>();
        
        List<List<Integer>> res = new ArrayList<>();
        
        for(int i=0;i<nums.length-2;i++) {
        	for(int j = i+1;j<nums.length-1;j++) {
        		for(int k = j+1;k<nums.length;k++) {
        			List<Integer> list = new ArrayList<>();
        			if(nums[i] + nums[j] + nums[k] == 0) {
        				if(nums[i] <= nums[j]&& nums[j] <= nums[k]) {
        					list.add(nums[i]);
        					list.add(nums[j]);
        					list.add(nums[k]);
        					
        				}
        				else if(nums[i] <= nums[k]&& nums[k] <= nums[j]) {
        					list.add(nums[i]);
        					list.add(nums[k]);
        					list.add(nums[j]);
        					
        				}
        				else if(nums[j] <= nums[i]&& nums[i] <= nums[k]) {
        					list.add(nums[j]);
        					list.add(nums[i]);
        					list.add(nums[k]);
        					
        				}
        				else if(nums[j] <= nums[k]&& nums[k] <= nums[i]) {
        					list.add(nums[j]);
        					list.add(nums[k]);
        					list.add(nums[i]);
        					
        				}
        				else if(nums[k] <= nums[i]&& nums[i] <= nums[j]) {
        					list.add(nums[k]);
        					list.add(nums[i]);
        					list.add(nums[j]);
        					
        				}
        				else {
        					list.add(nums[k]);
        					list.add(nums[j]);
        					list.add(nums[i]);
        				}
        				hash.add(list);
        			}
        		}
        	}
        }
        
        for(List<Integer> list : hash) {
        	res.add(list);
        }
        return res;
    }
}
