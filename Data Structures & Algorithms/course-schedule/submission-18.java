class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer,List<Integer>> map = new HashMap<>();

        int[] degree = new int[numCourses];

        for(int[] arr : prerequisites){
            int cur = arr[0];
            int pre = arr[1];
            if(!map.containsKey(pre)){
                map.put(pre,new ArrayList<>());
            }
            map.get(pre).add(cur);
            degree[cur]++;
        }

        Deque<Integer> q = new ArrayDeque<>();
        Set<Integer> set = new HashSet<>();

        for(int i=0;i<numCourses;i++){
            if(degree[i] == 0){
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int cur = q.poll();
            set.add(cur);
            if(map.containsKey(cur)){
                for(Integer i : map.get(cur)){
                    degree[i]--;
                    if(degree[i] == 0){
                        q.add(i);
                    }
                }
            }
        }

        if(set.size() == numCourses){
            return true;
        }
        return false;
    }
}
