class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length-k+1];
        Deque<Integer> dq = new ArrayDeque<>();
        for(int i = 0;i<nums.length;i++){
            if(dq.isEmpty() || nums[i] >= nums[dq.peekLast()]){
                dq.addLast(i);
            }
            else if(nums[i] <= nums[dq.peekFirst()]){
                dq.addFirst(i);
            }
            else{
                while(nums[dq.peekFirst()] < nums[i]){
                    dq.removeFirst();
                }
                dq.addFirst(i);
            }
            while(dq.peekLast() <= i-k){
                dq.removeLast();
            }
            if(i>=k-1){
                res[i-k+1]= nums[dq.peekLast()];
            }
        }
        return res;
    }
}
