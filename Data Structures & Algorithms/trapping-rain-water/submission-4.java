class Solution {
    public int trap(int[] height) {
        int count = 0;
        for(int i = 1;i<height.length-1;i++){
            int maxL = 0;
            int maxR = 0;
            for(int l =0;l<i;l++){
                if(height[l] > maxL){
                    maxL = height[l];
                }
            }
            if(maxL > height[i]){
                for(int r= i+1;r<height.length;r++){
                    if(height[r] > maxR){
                        maxR = height[r];
                    }
                }
            }
            if(maxL > height[i] && maxR > height[i]){
                count = count + Math.min(maxL,maxR) - height[i];
            }
        }
        return count;
    }
}
