class Solution {
    public void sortAlgo(int[] arr,int[] arr1){
        for(int i=0;i<arr.length-1;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[j] < arr[i]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    int temp1 = arr1[i];
                    arr1[i] = arr1[j];
                    arr1[j] = temp1;
                }
            }
        }
    }
    public int carFleet(int target, int[] position, int[] speed) {
        sortAlgo(position,speed);
        int res = position.length;
        int jump = 0;
        for (int i=position.length-1;i>0;i--){
            if(speed[i-1] <= speed[i+jump]){
                jump=0;
                continue;
            }
            if(position[i-1] == position[i+jump]){
                jump++;
                res--;
                continue;
            }
            double time = (double) (position[i-1] - position[i+jump]) / (double) (speed[i+jump] - speed[i-1]);
            double equalPos = (double) position[i-1] + (double) speed[i-1]*time;
            double tar = target;
            if(equalPos<=tar){
                res--;
                jump++;
            }
            else{
                jump = 0;
            }
        }

        return res;
    }
}
