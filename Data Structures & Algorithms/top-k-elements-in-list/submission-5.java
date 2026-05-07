class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        HashMap<Integer,Integer> map = new HashMap<>();
        for(Integer i : nums){
            map.putIfAbsent(i,0);
            map.put(i,map.get(i)+1);
        }
        PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<>(){
            public int compare(int[] a, int[] b){
                return b[1] - a[1];
            } 
        });
        for(Integer i : map.keySet()){
            q.add(new int[]{i,map.get(i)});
        }
        for(int i=0;i<k;i++){
            res[i] = q.poll()[0];
        }
        return res;
    }
}
