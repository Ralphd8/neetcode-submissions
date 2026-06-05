class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        int[] pre = new int[numCourses];

        for(int[] arr : prerequisites){
            int cur = arr[0];
            int prer = arr[1];
            if(!map.containsKey(prer)){
                map.put(prer,new ArrayList<Integer>());
            }
            map.get(prer).add(cur);
            pre[cur]++;
        }

        Queue<Integer> q = new LinkedList<>();
        int[] res = new int[numCourses];
        int count = 0;
        for(int i =0;i<numCourses;i++){
            if(pre[i] == 0){
                q.add(i);
                res[count] = i;
                count++;
            }
        }
        while(!q.isEmpty()){
            int cur = q.poll();
            if(map.containsKey(cur)){
                for(Integer i : map.get(cur)){
                    pre[i]--;
                    if(pre[i] == 0){
                        res[count] = i;
                        count++;
                        q.add(i);
                    }
                }
            }
        }
        if(count != numCourses){
            int[] a = new int[0];
            return a;
        }
        return res;
    }
}
