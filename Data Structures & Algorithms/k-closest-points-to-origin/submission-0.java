class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> q = new PriorityQueue<>(
                                                    (a, b) -> (a[0]*a[0] + a[1]*a[1]) 
                                                            - (b[0]*b[0] + b[1]*b[1])
                                                );
       
        for(int i = 0;i<points.length;i++){
            q.add(points[i]);
        }

        int[][] arr = new int[k][2];
        for(int i=0;i<k;i++){
            int[] cur = q.poll();
            arr[i][0] = cur[0];
            arr[i][1] = cur[1];
        }
        
        return arr;
    }
}
