class Solution {
    public void numsIslandsRecursive(int i,int j,char[][] grid,HashSet<ArrayList<Integer>> visited){
        if(j+1<grid[0].length){
            if(grid[i][j+1] != '0' && !visited.contains(new ArrayList<>(List.of(i,j+1)))){
                visited.add(new ArrayList<>(List.of(i,j+1)));
                numsIslandsRecursive(i,j+1,grid,visited);
            }
        }
        if(j-1>=0){
            if(grid[i][j-1] != '0' && !visited.contains(new ArrayList<>(List.of(i,j-1)))){
                visited.add(new ArrayList<>(List.of(i,j-1)));
                numsIslandsRecursive(i,j-1,grid,visited);
            }
        }
        if(i+1<grid.length){
            if(grid[i+1][j] != '0' && !visited.contains(new ArrayList<>(List.of(i+1,j)))){
                visited.add(new ArrayList<>(List.of(i+1,j)));
                numsIslandsRecursive(i+1,j,grid,visited);
            }
        }
        if(i-1>=0){
            if(grid[i-1][j] != '0' && !visited.contains(new ArrayList<>(List.of(i-1,j)))){
                visited.add(new ArrayList<>(List.of(i-1,j)));
                numsIslandsRecursive(i-1,j,grid,visited);
            }
        }
    }
    public int numIslands(char[][] grid) {
        HashSet<ArrayList<Integer>> visited = new HashSet<>();
        int count = 0;
        for(int i = 0;i<grid.length;i++){
            for(int j= 0;j<grid[0].length;j++){
                if(grid[i][j] != '0' && !visited.contains(new ArrayList<>(List.of(i,j)))){
                    count++;
                    visited.add(new ArrayList<>(List.of(i,j)));
                    numsIslandsRecursive(i,j,grid,visited);
                }
            }
        }
        return count;
    }
}
