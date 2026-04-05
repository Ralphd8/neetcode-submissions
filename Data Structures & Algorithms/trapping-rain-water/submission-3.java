class Solution {
    public int trap(int[] height) {
        int sum = 0;
        int prevSum=-1;
        int start = 0;
        int end = height.length-1;
        
        for(int i = 1;i<height.length-1;i++) {
        	if(prevSum == sum && height[i] >= height[i-1]) {
        		continue;
        	}
        	int curr = height[i];
        	int prevM = height[start];
        	int nextM = height[end];
        	while(start != i) {
        		if(height[start] >= prevM) {
        			prevM = height[start];
        		}
        		start++;
        	}
        	while(end != i) {
        		if(height[end] >= nextM) {
        			nextM = height[end];
        		}
        		end--;
        	}
        	if(prevM > curr && nextM > curr) {
        		prevSum = sum;
        		sum = sum + Math.min(prevM, nextM) - curr;
        	}
        	else {
        		prevSum = sum;
        	}
        	start = 0;
        	end = height.length-1;
        }
        return sum;
    }
}
