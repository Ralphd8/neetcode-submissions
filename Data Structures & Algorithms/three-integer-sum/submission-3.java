class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res= new ArrayList<>();    
        
        
        for(int i = 0; i<=nums.length-3;i++) {
        	for(int j = i+1; j<=nums.length-2;j++) {
        		for (int k = j+1; k<=nums.length-1 ; k++) {
        			if (nums[i] + nums[j] + nums[k] == 0) {
        				List<Integer> inter = new ArrayList<>();
        				inter.add(nums[i]);
        				inter.add(nums[j]);
        				inter.add(nums[k]);
        				int count = 0;
        				for(List<Integer> list : res) {
        					if (list.contains(nums[i]) && list.contains(nums[j]) && list.contains(nums[k])) {
        						break;
        					}
        					else {
        						count++;
        					}
        				}
        				if(count == res.size()) {
        					res.add(inter);
        				}
        			}
        		}
        	}
        }
        return res;
    }
}
