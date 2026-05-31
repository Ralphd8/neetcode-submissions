class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 0){
                    boolean[][] visited = new boolean[grid.length][grid[0].length];
                    int count = 0;
                    int[] arr = {i,j};
                    q.add(arr);
                    while(!q.isEmpty()){
                        int size = q.size();
                        for(int k=0;k<size;k++){
                            int[] a = q.poll();
                            int x = a[0];
                            int y = a[1];
                            visited[x][y] = true;
                            if(grid[x][y] != 0){
                                grid[x][y] = Math.min(grid[x][y],count);
                            }
                            if(x-1 >=0 && visited[x-1][y] == false && grid[x-1][y] != -1 && grid[x-1][y] != 0){
                                int[] array = {x-1,y};
                                q.add(array);
                            }
                            if(x+1 < grid.length && visited[x+1][y] == false && grid[x+1][y] != -1 && grid[x+1][y] != 0){
                                int[] array = {x+1,y};
                                q.add(array);
                            }
                            if(y-1 >=0 && visited[x][y-1] == false && grid[x][y-1] != -1 && grid[x][y-1] != 0){
                                int[] array = {x,y-1};
                                q.add(array);
                            }
                            if(y+1 < grid[0].length && visited[x][y+1] == false && grid[x][y+1] != -1 && grid[x][y+1] != 0){
                                int[] array = {x,y+1};
                                q.add(array);
                            }
                        }
                        count++;
                    }
                }
            }
        }
    }
}
