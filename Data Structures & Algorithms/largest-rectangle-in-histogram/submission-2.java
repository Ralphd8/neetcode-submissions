class Solution {
    public int largestRectangleArea(int[] heights) {
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<heights.length-1;i++){
            set.add(heights[i]);
            int minHeight = Math.min(heights[i],heights[i+1]);
            for(int j = i+1;j<heights.length;j++){
                minHeight = Math.min(minHeight,heights[j]);
                set.add((j-i+1)*minHeight);
            }
        }
        set.add(heights[heights.length-1]);
        int max = heights[0];
        for(Integer i : set){
            if(i > max){
                max = i;
            }
        }
        return max;
    }
}
