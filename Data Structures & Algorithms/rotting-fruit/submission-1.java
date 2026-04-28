class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid.length == 0) return -1;
        Queue<int[]> q = new LinkedList<>();

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 2){
                    q.add(new int[]{i,j});
                }
            }
        }

        int count = -1;

        while(!q.isEmpty()){
            int size = q.size();

            for(int t=0;t<size;t++){
                int[] arr = q.poll();

                if(arr[1]+1 < grid[0].length){
                    if(grid[arr[0]][arr[1]+1] == 1){
                        grid[arr[0]][arr[1]+1] = 2;
                        q.add(new int[]{arr[0],arr[1]+1});
                    }
                }
                if(arr[1]-1 >= 0){
                    if(grid[arr[0]][arr[1]-1] == 1){
                        grid[arr[0]][arr[1]-1] = 2;
                        q.add(new int[]{arr[0],arr[1]-1});
                    }
                }

                if(arr[0]+1 < grid.length){
                    if(grid[arr[0]+1][arr[1]] == 1){
                        grid[arr[0]+1][arr[1]] = 2;
                        q.add(new int[]{arr[0]+1,arr[1]});
                    }
                }
                if(arr[0]-1 >= 0){
                    if(grid[arr[0]-1][arr[1]] == 1){
                        grid[arr[0]-1][arr[1]] = 2;
                        q.add(new int[]{arr[0]-1,arr[1]});
                    }
                }
            }
            
            count++;
        }

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 1){
                    return -1;
                }
            }
        }

        if(count == -1) return 0;
        return count;

    }
}
