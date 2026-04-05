class Solution {
    public int largestRectangleArea(int[] heights) {
        int max =0;
        for(int i = 0;i<heights.length;i++) {
        	for(int j =i;j<heights.length;j++) {
        		if(i == j) {
        			if(heights[i] >=max) {
        				max = heights[i];
        			}
        		}
        		else {
        			int width = (j-i+1);
        			int minHeight = heights[i];
        			for(int a = i;a<=j;a++) {
        				if(heights[a] <= minHeight) {
        					minHeight = heights[a];
        				}
        			}
        			int area = width * minHeight;
        			if(area >= max) {
        				max = area;
        			}
        		}
        	}
        }
        return max;
    }
}
