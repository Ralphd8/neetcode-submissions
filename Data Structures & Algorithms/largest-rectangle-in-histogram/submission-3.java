class Solution {
    public int largestRectangleArea(int[] heights) {
        HashSet<Integer> set = new HashSet<>();
        for (Integer i : heights){
            set.add(i);
        }
        for(int i=0;i<heights.length;i++){
            int prev = i;
            int next = i;
            while(prev-1 >=0 && heights[prev-1] >= heights[i]){
                prev--;
            }
            while(next+1< heights.length && heights[next+1] >= heights[i]){
                next++;
            }
            set.add(heights[i] * (next-prev+1));
        }
        int max = 0;
        for(Integer i : set){
            if(i>max){
                max =i ;
            }
        }
        return max;
    }
}
