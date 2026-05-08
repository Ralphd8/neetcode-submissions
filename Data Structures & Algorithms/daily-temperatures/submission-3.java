class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Deque<Integer> dq = new ArrayDeque<>();

        for(int i=0;i<temperatures.length;i++){
            while(!dq.isEmpty() && temperatures[i] > temperatures[dq.peek()]){
                int top = dq.poll();
                res[top] = i - top;
            }
            dq.push(i);
        }

        return res;
    }
}
