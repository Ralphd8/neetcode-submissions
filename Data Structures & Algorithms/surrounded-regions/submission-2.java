class Solution {
    public void solve(char[][] board) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            for(int j =0;j<board[0].length;j++){
                if(board[i][j] == 'O' && visited[i][j] == false && i >0 && i< board.length && j > 0 && j < board[0].length){
                    Queue<int[]> q = new LinkedList<>();
                    HashSet<int[]> set = new HashSet<>();
                    boolean add = true;
                    int[] a = {i,j};
                    visited[i][j] = true;
                    set.add(a);
                    q.add(a);
                    while(!q.isEmpty()){
                        int[] cur = q.poll();
                        int x = cur[0];
                        int y = cur[1];
                        if(x == 0 || x == board.length-1 || y == 0 || y == board[0].length-1){add = false;}
                        if(x-1 >= 0 && visited[x-1][y] ==false && board[x-1][y] == 'O'){
                            int[] array = {x-1,y};
                            set.add(array);
                            q.add(array);
                            visited[x-1][y]= true;
                        }
                        if(x+1 <board.length && visited[x+1][y] ==false && board[x+1][y] == 'O'){
                            int[] array = {x+1,y};
                            set.add(array);
                            q.add(array);
                            visited[x+1][y] = true;
                        }
                        if(y-1 >= 0 && visited[x][y-1] ==false && board[x][y-1] == 'O'){
                            int[] array = {x,y-1};
                            set.add(array);
                            q.add(array);
                            visited[x][y-1] = true;
                        }
                        if(y+1 <board[0].length && visited[x][y+1] ==false && board[x][y+1] == 'O'){
                            int[] array = {x,y+1};
                            set.add(array);
                            q.add(array);
                            visited[x][y+1] = true;
                        }
                    }
                    if(add == true){
                        for(int[] arr : set){
                            int x = arr[0];
                            int y = arr[1];
                            board[x][y] = 'X';
                        }
                    }
                }
            }
        }
    }
}
