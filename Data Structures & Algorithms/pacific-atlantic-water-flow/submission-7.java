class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        boolean[][] pacific = new boolean[heights.length][heights[0].length];
        boolean[][] atlantic = new boolean[heights.length][heights[0].length];

        Queue<int[]> q = new LinkedList<>();

        for(int i = 0;i<heights[0].length;i++){
            int[] arr = {0,i};
            pacific[0][i] = true;
            q.add(arr);
        }
        for(int i=1;i<heights.length;i++){
            int[] arr = {i,0};
            pacific[i][0] = true;
            q.add(arr);
        }

        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                int[] arr = q.poll();
                int x = arr[0];
                int y = arr[1];
                
                if(x-1 >= 0 && pacific[x-1][y] == false && heights[x][y] <= heights[x-1][y]){
                    int[] array = {x-1,y};
                    pacific[x-1][y] = true;
                    q.add(array);
                }
                if(x+1 < heights.length && pacific[x+1][y] == false && heights[x][y] <= heights[x+1][y]){
                    int[] array = {x+1,y};
                    pacific[x+1][y] = true;
                    q.add(array);
                }
                if(y-1 >= 0 && pacific[x][y-1] == false && heights[x][y] <= heights[x][y-1]){
                    int[] array = {x,y-1};
                    pacific[x][y-1] = true;
                    q.add(array);
                }
                if(y+1 < heights[0].length && pacific[x][y+1] == false && heights[x][y] <= heights[x][y+1]){
                    int[] array = {x,y+1};
                    pacific[x][y+1] = true;
                    q.add(array);
                }
            }
        }

        q.clear();
        for(int i = 0;i<heights[0].length;i++){
            int[] arr = {heights.length-1,i};
            atlantic[heights.length-1][i] = true;
            q.add(arr);
        }
        for(int i=0;i<heights.length-1;i++){
            int[] arr = {i,heights[0].length-1};
            atlantic[i][heights[0].length-1] = true;
            q.add(arr);
        }

        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                int[] arr = q.poll();
                int x = arr[0];
                int y = arr[1];
                
                if(x-1 >= 0 && atlantic[x-1][y] == false && heights[x][y] <= heights[x-1][y]){
                    int[] array = {x-1,y};
                    atlantic[x-1][y] = true;
                    q.add(array);
                }
                if(x+1 < heights.length && atlantic[x+1][y] == false && heights[x][y] <= heights[x+1][y]){
                    int[] array = {x+1,y};
                    atlantic[x+1][y] = true;
                    q.add(array);
                }
                if(y-1 >= 0 && atlantic[x][y-1] == false && heights[x][y] <= heights[x][y-1]){
                    int[] array = {x,y-1};
                    atlantic[x][y-1] = true;
                    q.add(array);
                }
                if(y+1 < heights[0].length && atlantic[x][y+1] == false && heights[x][y] <= heights[x][y+1]){
                    int[] array = {x,y+1};
                    atlantic[x][y+1] = true;
                    q.add(array);
                }
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0;i<heights.length;i++){
            for(int j=0;j<heights[0].length;j++){
                if(pacific[i][j] == true && atlantic[i][j] == true){
                    List<Integer> arr = List.of(i,j);
                    res.add(arr);
                }
            }
        }
        return res;


    }
}
