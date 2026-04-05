class Solution {
    public int trap(int[] height) {
        int count = 0;
        for (int i = 1;i<height.length-1;i++){
            int prevMax = 0;
            int nextMax = 0;
            for(int x = i-1;x>=0;x--){
                if(height[x] > height[i] && height[x] > prevMax){
                    prevMax = height[x];
                }
            }
            for(int x = i+1;x<=height.length-1;x++){
                if(height[x]> height[i] && height[x] > nextMax){
                    nextMax = height[x];
                }
            }
            int addition = Math.min(prevMax,nextMax) - height[i];
            if(addition>0){
                count = count + addition;
            }
        }
        return count;
    }
}
