class Solution {
    public void solve(char[][] board) {
        List<String> arr = new ArrayList<>();
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[board.length][board[0].length];
        boolean proceed = false;

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j] == 'O' && !visited[i][j] && i > 0 && i<board.length-1 && j > 0 && j<board[0].length-1){
                    arr.clear();
                    q.clear();
                    visited[i][j] = true;
                    int[] a = new int[]{i,j};
                    q.add(a);
                    arr.add(i+","+j);
                    proceed = true;
                    while(!q.isEmpty() && proceed){
                        int[] array = q.poll();
                        if(array[1]+1 < board[0].length){
                            if(board[array[0]][array[1]+1] != 'X'){
                                if(visited[array[0]][array[1]+1] && !arr.contains(array[0]+","+(array[1]+1)) || array[1]+1 == board[0].length-1){
                                    proceed = false;
                                }
                                else if(!visited[array[0]][array[1]+1]){
                                    int[] b = new int[]{array[0],array[1]+1};
                                    q.add(b);
                                    arr.add(array[0]+","+(array[1]+1));
                                }
                                visited[array[0]][array[1]+1] = true;
                            }
                        }
                        if(array[1]-1 >= 0){
                            if(board[array[0]][array[1]-1] != 'X'){
                                if(visited[array[0]][array[1]-1] && !arr.contains(array[0]+","+(array[1]-1)) || array[1]-1 == 0){
                                    proceed = false;
                                }
                                else if(!visited[array[0]][array[1]-1]){
                                    int[] b = new int[]{array[0],array[1]-1};
                                    q.add(b);
                                    arr.add(array[0]+","+(array[1]-1));
                                }
                                visited[array[0]][array[1]-1] = true;
                            }
                        }
                        if(array[0]+1 < board.length){
                            if(board[array[0]+1][array[1]] != 'X'){
                                if(visited[array[0]+1][array[1]] && !arr.contains((array[0]+1)+","+array[1]) || array[0]+1 == board.length-1){
                                    proceed = false;
                                }
                                else if(!visited[array[0]+1][array[1]]){
                                    int[] b = new int[]{array[0]+1,array[1]};
                                    q.add(b);
                                    arr.add((array[0]+1)+","+array[1]);
                                }
                                visited[array[0]+1][array[1]] = true;
                            }
                        }
                        if(array[0]-1 >= 0){
                            if(board[array[0]-1][array[1]] != 'X'){
                                if(visited[array[0]-1][array[1]] && !arr.contains((array[0]-1)+","+array[1]) || array[0]-1 == 0){
                                    proceed = false;
                                }
                                else if(!visited[array[0]-1][array[1]]){
                                    int[] b = new int[]{array[0]-1,array[1]};
                                    q.add(b);
                                    arr.add((array[0]-1)+","+array[1]);
                                }
                                visited[array[0]-1][array[1]] = true;
                            }
                        }
                    }
                    if(proceed){
                        for(String s : arr){
                            int comma = 1;
                            for(int t = 0;t<s.length();t++){
                                if(s.charAt(t) == ',') comma = t;
                            }
                            int x = Integer.parseInt(s.substring(0,comma));
                            int y = Integer.parseInt(s.substring(comma+1));
                            board[x][y] = 'X';
                        }
                    }
                }
            }
        }
    }
}
