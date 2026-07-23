class Solution {
    public void DFS(int[][] grid,int i,int j){
        int cur = grid[i][j];
        if(i-1 >=0 && cur < grid[i-1][j]){
            grid[i-1][j] = cur+1;
            DFS(grid,i-1,j);
        }
        if(i+1 < grid.length && cur < grid[i+1][j]){
            grid[i+1][j] = cur+1;
            DFS(grid,i+1,j);
        }
        if(j-1 >=0 && cur < grid[i][j-1]){
            grid[i][j-1] = cur+1;
            DFS(grid,i,j-1);
        }
        if(j+1 < grid[0].length && cur < grid[i][j+1]){
            grid[i][j+1] = cur+1;
            DFS(grid,i,j+1);
        }
    }
    public void islandsAndTreasure(int[][] grid) {
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 0){
                    // call the method;
                    DFS(grid,i,j);
                }
            }
        }
    }
}
