class Solution {
    public void helper(char[][] grid, int i, int j,boolean[][] visited){
        if(visited[i][j]){return;}
        visited[i][j] = true;

        if(i-1 >= 0 && visited[i-1][j] == false && grid[i-1][j] == '1'){
            helper(grid,i-1,j,visited);
        }
        if(i+1 < visited.length && visited[i+1][j] == false && grid[i+1][j] == '1'){
            helper(grid,i+1,j,visited);
        }
        if(j-1 >= 0 && visited[i][j-1] == false && grid[i][j-1] == '1'){
            helper(grid,i,j-1,visited);
        }
        if(j+1 < visited[0].length && visited[i][j+1] == false && grid[i][j+1] == '1'){
            helper(grid,i,j+1,visited);
        }
    }
    public int numIslands(char[][] grid) {
        int count = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(visited[i][j] == false && grid[i][j] == '1'){
                    count++;
                    helper(grid,i,j,visited);
                }
            }
        }
        return count;
    }
}
