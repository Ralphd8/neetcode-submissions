class Solution {
    int temp = 0;
    public void maxAreaOfIslandRecursive(int i,int j,int[][] grid,boolean[][] visited){
        visited[i][j] = true;
        if(j+1<grid[0].length){
            if(grid[i][j+1] != 0 && !visited[i][j+1]){
                temp++;
                maxAreaOfIslandRecursive(i,j+1,grid,visited);
            }
        }
        if(j-1>=0){
            if(grid[i][j-1] != 0 && !visited[i][j-1]){
                temp++;
                maxAreaOfIslandRecursive(i,j-1,grid,visited);
            }
        }
        if(i+1<grid.length){
            if(grid[i+1][j] != 0 && !visited[i+1][j]){
                temp++;
                maxAreaOfIslandRecursive(i+1,j,grid,visited);
            }
        }
        if(i-1>=0){
            if(grid[i-1][j] != 0 && !visited[i-1][j]){
                temp++;
                maxAreaOfIslandRecursive(i-1,j,grid,visited);
            }
        }
    }
    public int maxAreaOfIsland(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int res=0;

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] != 0 && !visited[i][j]){
                    temp++;
                    visited[i][j] = true;
                    maxAreaOfIslandRecursive(i,j,grid,visited);
                    if(temp>res){
                        res = temp;
                    }
                    temp = 0;
                }
            }
        }

        return res;
    }
}
