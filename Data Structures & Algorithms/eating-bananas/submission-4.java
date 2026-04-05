class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for (int i=0 ;i < piles.length ;i++){
            if(piles[i] > max){
                max = piles[i];
            }
        }
        if(h == piles.length){
            return max;
        }
        return intermediate(piles,h,1,max);

    }
    public int res(int[] piles,int k){
        int sum = 0;
        for(int i=0;i<piles.length;i++){
            double p = piles[i];
            double l = k;
            int r = (int) Math.ceil(p/l);
            sum = sum + r;
        }
        return sum;
    }
    public int intermediate(int[] piles,int h,int min,int max){
        int mid = (min+max)/2;
        if(min == max){
            return min;
        }
        else if(res(piles,mid) <= h){
            return intermediate(piles,h,min,mid);
        }
        else{
            return intermediate(piles,h,mid+1,max);
        }
    }
}
