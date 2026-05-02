class KthLargest {

    int k;
    int[] nums;
    PriorityQueue<Integer> q = new PriorityQueue<>((a,b) -> b-a);

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.nums = nums;
        for(Integer i : nums){
            q.add(i);
        }
    }
    
    public int add(int val) {
        int cur = k;
        q.add(val);
        int[] arr = new int[cur-1];
        for(int i = 0;i<cur-1;i++){
            arr[i] = q.poll();
        }
        int res = q.peek();
        for(int i = 0;i<cur-1;i++){
            q.add(arr[i]);
        }
        return res;
    }
}
