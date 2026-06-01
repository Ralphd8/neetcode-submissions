class Solution {
    public boolean pacific(int[][] heights,int i,int j){
        if(i ==0 || j==0){
            return true;
        }
        return false;
    }
    public boolean atlantic(int[][] heights,int i,int j){
        if(i == heights.length-1 || j==heights[0].length-1){
            return true;
        }
        return false;
    }

    public boolean checkPacific(int[][] heights,int i,int j,boolean[][] visited){
        if(pacific(heights,i,j)){return true;}

        visited[i][j] = true;
        boolean top = false;
        boolean bottom = false;
        boolean right = false;
        boolean left = false;

        if(i-1 >= 0 && heights[i-1][j] <= heights[i][j] && visited[i-1][j] == false){
            top = checkPacific(heights,i-1,j,visited);
        }
        if(i+1 < heights.length && heights[i+1][j] <= heights[i][j] && visited[i+1][j] == false){
            bottom = checkPacific(heights,i+1,j,visited);
        }
        if(j-1 >= 0 && heights[i][j-1] <= heights[i][j] && visited[i][j-1] == false){
            left = checkPacific(heights,i,j-1,visited);
        }
        if(j+1 < heights[0].length && heights[i][j+1] <= heights[i][j] && visited[i][j+1] == false){
            right = checkPacific(heights,i,j+1,visited);
        }

        return top || bottom || right || left;
    }

    public boolean checkAtlantic(int[][] heights,int i,int j,boolean[][] visited){
        if(atlantic(heights,i,j)){return true;}
        visited[i][j] = true;
        boolean top = false;
        boolean bottom = false;
        boolean right = false;
        boolean left = false;

        if(i-1 >= 0 && heights[i-1][j] <= heights[i][j] && visited[i-1][j] == false){
            top = checkAtlantic(heights,i-1,j,visited);
        }
        if(i+1 < heights.length && heights[i+1][j] <= heights[i][j] && visited[i+1][j] == false){
            bottom = checkAtlantic(heights,i+1,j,visited);
        }
        if(j-1 >= 0 && heights[i][j-1] <= heights[i][j] && visited[i][j-1] == false){
            left = checkAtlantic(heights,i,j-1,visited);
        }
        if(j+1 < heights[0].length && heights[i][j+1] <= heights[i][j] && visited[i][j+1] == false){
            right = checkAtlantic(heights,i,j+1,visited);
        }

        return top || bottom || right || left;
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();

        for(int i=0;i<heights.length;i++){
            for(int j=0;j<heights[0].length;j++){
                boolean[][] visited = new boolean[heights.length][heights[0].length];
                boolean atl = checkAtlantic(heights,i,j,visited);
                visited = new boolean[heights.length][heights[0].length];
                boolean pac = checkPacific(heights,i,j,visited);
                if(pac && atl){
                    List<Integer> arr = List.of(i,j);
                    res.add(arr);
                }
            }
        }

        return res;
    }
}
