class Solution {
    
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

        while(!q.isEmpty()){
            List<Integer> arr = q.poll();

            if(arr.get(1)+1 < heights[0].length){
                if(pacificbool[arr.get(0)][arr.get(1)+1] == false && heights[arr.get(0)][arr.get(1)+1] >= heights[arr.get(0)][arr.get(1)]){
                    pacificbool[arr.get(0)][arr.get(1)+1] = true;
                    List<Integer> array = new ArrayList<>(List.of(arr.get(0),arr.get(1)+1));
                    q.add(array);
                }
            }
            if(arr.get(1)-1 >= 0){
                if(pacificbool[arr.get(0)][arr.get(1)-1] == false && heights[arr.get(0)][arr.get(1)-1] >= heights[arr.get(0)][arr.get(1)]){
                    pacificbool[arr.get(0)][arr.get(1)-1] = true;
                    List<Integer> array = new ArrayList<>(List.of(arr.get(0),arr.get(1)-1));
                    q.add(array);
                }
            }
            if(arr.get(0)+1 < heights.length){
                if(pacificbool[arr.get(0)+1][arr.get(1)] == false && heights[arr.get(0)+1][arr.get(1)] >= heights[arr.get(0)][arr.get(1)]){
                    pacificbool[arr.get(0)+1][arr.get(1)] = true;
                    List<Integer> array = new ArrayList<>(List.of(arr.get(0)+1,arr.get(1)));
                    q.add(array);
                }
            }
            if(arr.get(0)-1 >= 0){
                if(pacificbool[arr.get(0)-1][arr.get(1)] == false && heights[arr.get(0)-1][arr.get(1)] >= heights[arr.get(0)][arr.get(1)]){
                    pacificbool[arr.get(0)-1][arr.get(1)] = true;
                    List<Integer> array = new ArrayList<>(List.of(arr.get(0)-1,arr.get(1)));
                    q.add(array);
                }
            }
        }

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

        while(!q.isEmpty()){
            List<Integer> arr = q.poll();

            if(arr.get(1)+1 < heights[0].length){
                if(atlanticbool[arr.get(0)][arr.get(1)+1] == false && heights[arr.get(0)][arr.get(1)+1] >= heights[arr.get(0)][arr.get(1)]){
                    atlanticbool[arr.get(0)][arr.get(1)+1] = true;
                    List<Integer> array = new ArrayList<>(List.of(arr.get(0),arr.get(1)+1));
                    q.add(array);
                }
            }
            if(arr.get(1)-1 >= 0){
                if(atlanticbool[arr.get(0)][arr.get(1)-1] == false && heights[arr.get(0)][arr.get(1)-1] >= heights[arr.get(0)][arr.get(1)]){
                    atlanticbool[arr.get(0)][arr.get(1)-1] = true;
                    List<Integer> array = new ArrayList<>(List.of(arr.get(0),arr.get(1)-1));
                    q.add(array);
                }
            }
            if(arr.get(0)+1 < heights.length){
                if(atlanticbool[arr.get(0)+1][arr.get(1)] == false && heights[arr.get(0)+1][arr.get(1)] >= heights[arr.get(0)][arr.get(1)]){
                    atlanticbool[arr.get(0)+1][arr.get(1)] = true;
                    List<Integer> array = new ArrayList<>(List.of(arr.get(0)+1,arr.get(1)));
                    q.add(array);
                }
            }
            if(arr.get(0)-1 >= 0){
                if(atlanticbool[arr.get(0)-1][arr.get(1)] == false && heights[arr.get(0)-1][arr.get(1)] >= heights[arr.get(0)][arr.get(1)]){
                    atlanticbool[arr.get(0)-1][arr.get(1)] = true;
                    List<Integer> array = new ArrayList<>(List.of(arr.get(0)-1,arr.get(1)));
                    q.add(array);
                }
            }
        }

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
