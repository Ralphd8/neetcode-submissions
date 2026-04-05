class Solution {
    public int inter(int[] nums,int h,int min,int max){
        if(h == nums.length){
            return max;
        }
        if(min==max){
            return min;
        }
        if(max-min==1){
            double count = 0;
            for(Integer i : nums){
                count = count + Math.ceil(((double) i)/((double) min));
            }
            int c = (int) count;
            if(c<=h){
                return min;
            }
            else{
                return max;
            }
        }
        int mid = (min+max)/2;
        double count = 0;
        for(Integer i : nums){
            count = count + Math.ceil(((double) i)/((double) mid));
        }
        int c = (int) count;
        if(c<=h){
            return inter(nums,h,min,mid);
        }
        else{
            return inter(nums,h,mid+1,max);
        }
    }
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for(Integer i : piles){
            if(i>max){
                max = i;
            }
        }
        return inter(piles,h,1,max);
    }
}
