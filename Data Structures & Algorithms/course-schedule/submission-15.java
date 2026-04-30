class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites.length == 0) return true;
        HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();

        for(int[] arr : prerequisites){
            if(map.containsKey(arr[0])){
                map.get(arr[0]).add(arr[1]);
            }
            else{
                ArrayList<Integer> list = new ArrayList<>();
                list.add(arr[1]);
                map.put(arr[0], list);
            }
        }

        
        Queue<Integer> q = new LinkedList<>();
    
        for(int i=0;i<numCourses;i++){
            if(!map.containsKey(i)){
                continue;
            }
            q.add(i);
            boolean[] visited = new boolean[numCourses];
            while(!q.isEmpty()){
                
                int cur = q.poll();
                visited[cur] = true;

                for(Integer inte : map.get(cur)){
                    if(visited[inte] == true && map.containsKey(inte)){
                        for(Integer t : map.get(inte)){
                            if(visited[t] == true){
                                return false;
                            }
                        }
                    }
                    if(map.containsKey(inte)){
                        q.add(inte);
                        visited[inte] = true;
                    }
                }
            }

        }

        return true;
    }
}

