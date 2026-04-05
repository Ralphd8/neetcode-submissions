class Solution {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        int count = 1 ;
        HashSet<Integer> hash = new HashSet<>();
        if(nums.length == 1 || nums.length == 0) {
        	return nums.length;
        }
        for (int i = 1;i<nums.length;i++) {
        	if(nums[i] == nums[i-1]+1 && i == nums.length-1) {
        		count++;
        		hash.add(count);
        	}
        	else if(nums[i] == nums[i-1] && i == nums.length-1) {
        		count = count+0;
        		hash.add(count);
        	}
        	else if (nums[i] == nums[i-1]+1){
        		count++;
        	}
        	else if(nums[i] == nums[i-1]) {
        		count = count+0;
        	}
        	else {
        		hash.add(count);
        		count= 1;
        	}
        }
        
        int max = 0;
        for(int i : hash) {
        	if(i>max) {
        		max = i;
        	}
        }
        return max;
    }
}
