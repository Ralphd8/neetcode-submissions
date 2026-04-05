class Solution {
    public boolean containsDuplicate(ArrayList<Character> array) {
        HashSet<Character> set = new HashSet<>();
        for (Character item : array) {
            if (!set.add(item)) { 
                return true;
            }
        }
        return false;
    }
    public boolean isValidSudoku(char[][] board) {
        ArrayList<Character> num = new ArrayList<>(Arrays.asList('1','2','3','4','5','6','7','8','9'));
        for (int i = 0;i<9;i++){
            ArrayList<Character> array = new ArrayList<>();
            for(int j=0;j<9;j++){
                if(num.contains(board[i][j])){
                    array.add(board[i][j]);
                }
            }
            if (containsDuplicate(array) == true){
                return false;
            }
        }
        for (int i = 0;i<9;i++){
            ArrayList<Character> array = new ArrayList<>();
            for(int j=0;j<9;j++){
                if(num.contains(board[j][i])){
                    array.add(board[j][i]);
                }
                
            }
            if (containsDuplicate(array) == true){
                return false;
            }
        }
        for (int x = 0;x<9;x=x+3){
            for (int y = 0 ; y<9;y=y+3){
                ArrayList<Character> array = new ArrayList<>();
                for (int i=x;i<x+3;i++){
                    for (int j=y;j<y+3;j++){
                        if(num.contains(board[i][j])){
                            array.add(board[i][j]);
                        }
                    }
                }
                if (containsDuplicate(array) == true){
                    return false;
                }
            }
        }
        return true;
        
    }
}
