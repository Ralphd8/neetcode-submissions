class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        for (int i = 0;i<temperatures.length;i++){
            int j = 1;
            while((i+j) < temperatures.length && temperatures[i+j] <= temperatures[i]){
                j++;
            }
            if((i+j) == temperatures.length){
                res[i] = 0;
            }
            else{
                res[i] = j;
            }
        }
        return res;
    }
}
