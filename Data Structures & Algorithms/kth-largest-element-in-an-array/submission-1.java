class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>(new Comparator<>(){
            public int compare(Integer a,Integer b){
                return b-a;
            }
        });
        for(Integer i : nums){q.add(i);}
        for(int i =0;i<k-1;i++){
            q.poll();
        }
        return q.peek();
    }
}
