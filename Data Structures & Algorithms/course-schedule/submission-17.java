class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        int[] degree = new int[numCourses];

        for(int[] arr : prerequisites){
            int cur = arr[0];
            int pre = arr[1];
            if(!map.containsKey(pre)){
                map.put(pre,new ArrayList<Integer>());
            }
            map.get(pre).add(cur);
            degree[cur]++;
        }

        Queue<Integer> q = new LinkedList<>();
        Set<Integer> set = new HashSet<>();

        for(int i =0;i<degree.length;i++){
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
