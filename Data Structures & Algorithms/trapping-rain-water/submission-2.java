class Solution {
    public int trap(int[] height) {
        if (height.length == 0){
            return 0;
        }
        int count = 0;
        for (int i = 1 ;i<height.length-1 ; i++){
            int maxl = 0;
            int maxr = 0;
            for (int j = 0 ;j<i;j++){
                if(height[j]> maxl){
                    maxl = height[j];
                }
            }
            for (int j = i+1;j<= height.length-1 ; j++){
                if(height[j] > maxr){
                    maxr = height[j];
                }
            }
            if(maxl <= height[i] || maxr <= height[i]){
                continue;
            }
            int water = (int) Math.min(maxr,maxl);
            int water1 = water - height[i];
            count = count + water1;

        }
        return count;
    }
}
