class Solution {
    public int largestRectangleArea(int[] heights) {
        HashSet<Integer> hash = new HashSet<>();
        for(int i = 0 ; i<heights.length;i++) {
        	hash.add(heights[i]);
        }
        for (int i=0;i<heights.length-1;i++) {
        	for (int j = i+1;j<heights.length;j++) {
        		int min = heights[i];
        		for (int k = i;k<=j;k++) {
        			if(heights[k]<min) {
        				min = heights[k];
        			}
        		}
        		hash.add(min*(j-i+1));
        	}
        }
        int max = 0;
        for(int i :hash) {
        	if(i>max) {
        		max =i;
        	}
        }
        return max;
    }
}
