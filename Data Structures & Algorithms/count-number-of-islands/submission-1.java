class Solution {
    public void numsIslandsRecursive(int i,int j,char[][] grid,boolean[][] visited){
        if(j+1<grid[0].length){
            if(grid[i][j+1] != '0' && !visited[i][j+1]){
                visited[i][j+1] = true;
                numsIslandsRecursive(i,j+1,grid,visited);
            }
        }
        if(j-1>=0){
            if(grid[i][j-1] != '0' && !visited[i][j-1]){
                visited[i][j-1] = true;
                numsIslandsRecursive(i,j-1,grid,visited);
            }
        }
        if(i+1<grid.length){
            if(grid[i+1][j] != '0' && !visited[i+1][j]){
                visited[i+1][j] = true;
                numsIslandsRecursive(i+1,j,grid,visited);
            }
        }
        if(i-1>=0){
            if(grid[i-1][j] != '0' && !visited[i-1][j]){
                visited[i-1][j] = true;
                numsIslandsRecursive(i-1,j,grid,visited);
            }
        }
    }
    public int numIslands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int count = 0;
        for(int i = 0;i<grid.length;i++){
            for(int j= 0;j<grid[0].length;j++){
                if(grid[i][j] != '0' && !visited[i][j]){
                    count++;
                    visited[i][j] = true;
                    numsIslandsRecursive(i,j,grid,visited);
                }
            }
        }
        return count;
    }
}
