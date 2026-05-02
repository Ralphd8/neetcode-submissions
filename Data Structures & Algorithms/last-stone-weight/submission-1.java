class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> q = new PriorityQueue<>((a,b) -> b-a);
        for(Integer i : stones){
            q.add(i);
        }
        while(q.size() > 1){
            int first = q.poll();
            int second = q.poll();
            int diff = (int) Math.abs(first-second);
            if(diff>0){
                q.add(diff);
            }
            if(q.size() == 0 && diff == 0){
                return 0;
            }
        }
        return q.peek();
    }
}
