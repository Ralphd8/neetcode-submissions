class Solution {
    public int maxArea(int[] heights) {
        List<Integer> res = new ArrayList<>();
        
        for (int i = 0; i<heights.length-1 ; i++) {
        	for (int j = i+1 ; j<= heights.length-1 ;j++) {
        		res.add(Math.min(heights[i], heights[j]) * (j-i));
        	}
        }
        int max = 0;
        for (int i : res) {
        	if (i>max) {
        		max = i;
        	}
        }
        return max;
    }
}
