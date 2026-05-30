class Solution {
    public int helper(int[][] grid,int i,int j){
        if(grid[i][j] == 0){
            return 0;
        }
        grid[i][j] = 0;

        int up = 0;
        int down = 0;
        int right = 0;
        int left = 0;

        if(i-1 >= 0 && grid[i-1][j] == 1){
            left = helper(grid,i-1,j);
        }
        if(i+1 < grid.length && grid[i+1][j] == 1){
            right = helper(grid,i+1,j);
        }
        if(j-1 >= 0 && grid[i][j-1] == 1){
            up = helper(grid,i,j-1);
        }
        if(j+1 < grid[0].length && grid[i][j+1] == 1){
            down = helper(grid,i,j+1);
        }

        return 1 + up + down + right + left;
    }
    public int maxAreaOfIsland(int[][] grid) {
        int max = Integer.MIN_VALUE;

        for(int i = 0 ;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 1){
                    int cur = helper(grid,i,j);
                    max = Math.max(max,cur);
                }
            }
        }
        if(max == Integer.MIN_VALUE){
            return 0;
        }
        return max;
    }
}
