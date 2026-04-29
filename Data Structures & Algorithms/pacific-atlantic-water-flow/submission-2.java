class Solution {
    
    public void recursion(int[][] heights,boolean[][] bool,Queue<List<Integer>> q){
        while(!q.isEmpty()){
            List<Integer> arr = q.poll();

            if(arr.get(1)+1 < heights[0].length){
                if(bool[arr.get(0)][arr.get(1)+1] == false && heights[arr.get(0)][arr.get(1)+1] >= heights[arr.get(0)][arr.get(1)]){
                    bool[arr.get(0)][arr.get(1)+1] = true;
                    List<Integer> array = new ArrayList<>(List.of(arr.get(0),arr.get(1)+1));
                    q.add(array);
                }
            }
            if(arr.get(1)-1 >= 0){
                if(bool[arr.get(0)][arr.get(1)-1] == false && heights[arr.get(0)][arr.get(1)-1] >= heights[arr.get(0)][arr.get(1)]){
                    bool[arr.get(0)][arr.get(1)-1] = true;
                    List<Integer> array = new ArrayList<>(List.of(arr.get(0),arr.get(1)-1));
                    q.add(array);
                }
            }
            if(arr.get(0)+1 < heights.length){
                if(bool[arr.get(0)+1][arr.get(1)] == false && heights[arr.get(0)+1][arr.get(1)] >= heights[arr.get(0)][arr.get(1)]){
                    bool[arr.get(0)+1][arr.get(1)] = true;
                    List<Integer> array = new ArrayList<>(List.of(arr.get(0)+1,arr.get(1)));
                    q.add(array);
                }
            }
            if(arr.get(0)-1 >= 0){
                if(bool[arr.get(0)-1][arr.get(1)] == false && heights[arr.get(0)-1][arr.get(1)] >= heights[arr.get(0)][arr.get(1)]){
                    bool[arr.get(0)-1][arr.get(1)] = true;
                    List<Integer> array = new ArrayList<>(List.of(arr.get(0)-1,arr.get(1)));
                    q.add(array);
                }
            }
        }
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<List<Integer>> q = new LinkedList<>();
        
        boolean[][] pacificbool = new boolean[heights.length][heights[0].length];
        for(int i=0;i<heights[0].length;i++){
            pacificbool[0][i] = true;
            List<Integer> arr = new ArrayList<>(List.of(0,i));
            q.add(arr);
        }
        for(int i =0;i<heights.length;i++){
            pacificbool[i][0] = true;
            List<Integer> arr = new ArrayList<>(List.of(i,0));
            q.add(arr);
        }

        recursion(heights,pacificbool,q);
        

        boolean[][] atlanticbool = new boolean[heights.length][heights[0].length];

        for(int i=heights[0].length-1;i>=0;i--){
            atlanticbool[heights.length-1][i] = true;
            List<Integer> arr = new ArrayList<>(List.of(heights.length-1,i));
            q.add(arr);
        }
        for(int i =heights.length-1;i>=0;i--){
            atlanticbool[i][heights[0].length-1] = true;
            List<Integer> arr = new ArrayList<>(List.of(i,heights[0].length-1));
            q.add(arr);
        }

        recursion(heights,atlanticbool,q);

        for(int i=0;i<heights.length;i++){
            for(int j=0;j<heights[0].length;j++){
                if(atlanticbool[i][j] == true && pacificbool[i][j] == true){
                    List<Integer> arr = new ArrayList<>(List.of(i,j));
                    res.add(arr);
                }
            }
        }

        return res;
    }
}
