class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 2){
                    int[] arr = {i,j};
                    q.add(arr);
                }
            }
        }
        

        int count = 0;
        while(!q.isEmpty()){
            int size = q.size();

            for(int i=0;i<size;i++){
                int[] arr = q.poll();
                int x = arr[0];
                int y = arr[1];

                if(x-1 >=0 && grid[x-1][y] == 1){
                    grid[x-1][y] = 2;
                    int[] a = {x-1,y};
                    q.add(a);
                }
                if(x+1 <grid.length && grid[x+1][y] == 1){
                    grid[x+1][y] = 2;
                    int[] a = {x+1,y};
                    q.add(a);
                }
                if(y-1 >=0 && grid[x][y-1] == 1){
                    grid[x][y-1] = 2;
                    int[] a = {x,y-1};
                    q.add(a);
                }
                if(y+1 <grid[0].length && grid[x][y+1] == 1){
                    grid[x][y+1] = 2;
                    int[] a = {x,y+1};
                    q.add(a);
                }
            }
            if(q.size() > 0){
                count++;
            }
        }
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 1){
                    return -1;
                }
            }
        }
        return count;
    }
}
