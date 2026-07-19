class Solution {
    public int dfs(int[][] grid,int i,int j){
        if(grid[i][j] == 0){return 0;}
        grid[i][j] = 0;

        int up = 0;
        int down = 0;
        int left = 0;
        int right = 0;

        if(i-1 >=0 && grid[i-1][j] == 1){
            up = dfs(grid,i-1,j);
        }
        if(i+1 < grid.length && grid[i+1][j] == 1){
            down = dfs(grid,i+1,j);
        }
        if(j-1 >=0 && grid[i][j-1] == 1){
            left = dfs(grid,i,j-1);
        }
        if(j+1 < grid[0].length && grid[i][j+1] == 1){
            right = dfs(grid,i,j+1);
        }

        return 1 + up + down + left + right;
    }
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 1){
                    int cur = dfs(grid,i,j);
                    max = Math.max(max,cur);
                }
            }
        }
        return max;
    }
}
