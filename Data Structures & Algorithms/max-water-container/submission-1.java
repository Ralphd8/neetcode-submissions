class Solution {
    public int maxArea(int[] heights) {
        int max = -1;
        for(int i = 0;i<heights.length-1;i++) {
        	for(int j = i+1;j<heights.length;j++) {
        		int area = (j-i)*Math.min(heights[i],heights[j]);
        		if(area>max) {
        			max = area;
        		}
        	}
        }
        return max;
    }
}
