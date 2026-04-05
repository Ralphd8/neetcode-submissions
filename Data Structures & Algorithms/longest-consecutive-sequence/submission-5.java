class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        for(int i = 0;i<nums.length-1;i++) {
        	for(int j =0;j<nums.length-1-i;j++) {
        		if(nums[j] > nums[j+1]) {
        			int temp = nums[j];
        			nums[j] = nums[j+1];
        			nums[j+1] = temp;
        		}
        	}
        }
        
        HashSet<Integer> set = new HashSet<>();
        int count=1;
        for(int i = 0;i<nums.length;i++) {
        	if(i == nums.length-1) {
        		set.add(count);
        	}
        	else if(nums[i+1] == nums[i]) {
        		count = count+0;
        	}
        	else if(nums[i+1] > nums[i]+1) {
        		set.add(count);
        		count=1;
        	}
        	else {
        		count++;
        	}
        }
        
        int max = 1;
        for(int i : set) {
        	if(i>=max) {
        		max=i;
        	}
        }
        return max;
    }
}
