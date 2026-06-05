class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length != n-1){
            return false;
        }

        HashMap<Integer,List<Integer>> map = new HashMap<>();
        for(int[] arr : edges){
            int f =  arr[0];
            int s = arr[1];
            if(!map.containsKey(f)){
                map.put(f,new ArrayList<>());
            }
            map.get(f).add(s);
            if(!map.containsKey(s)){
                map.put(s,new ArrayList<>());
            }
            map.get(s).add(f);
        }

        Queue<Integer> q = new ArrayDeque<>();
        HashSet<Integer> set = new HashSet<>();
        q.add(0);
        set.add(0);
        while(!q.isEmpty()){
            int cur = q.poll();
            if(map.containsKey(cur)){
                for(Integer i : map.get(cur)){
                    if(!set.contains(i)){
                        q.add(i);
                        set.add(i);
                    }
                }
            }
        }

        if(set.size() == n){return true;}
        return false;
    }
}
