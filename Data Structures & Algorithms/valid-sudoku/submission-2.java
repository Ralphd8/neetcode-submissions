class Solution {
    public boolean isValidSudoku(char[][] board) {
        // first checking if the rows follows the rule
		for (int i =0 ;i<board.length;i++) {
			HashMap<Character,Integer> map = new HashMap<>();
			for(int j = 0 ;j<board[0].length;j++) {
				if(board[i][j] != '.') {
					if(map.containsKey(board[i][j])) {
						return false;
					}
					
					map.put(board[i][j], 1);
					
				}
			}
		}
		
		// second checking if the columns follows the rule
		for (int i =0 ;i<board[0].length;i++) {
			HashMap<Character,Integer> map = new HashMap<>();
			for(int j = 0 ;j<board.length;j++) {
				if(board[j][i] != '.') {
					if(map.containsKey(board[j][i])) {
						return false;
					}
					
					map.put(board[j][i], 1);
					
				}
			}
		}
		
		// third checking if the boxes follows the rule
		
		for (int i =0 ;i<9;i=i+3) {
			for (int j = 0;j<9;j=j+3) {
				HashMap<Character,Integer> map = new HashMap<>();
				for(int a = i;a<= i+2 ;a++) {
					
					for(int b = j; b <= j+2;b++) {
						if(board[a][b] != '.') {
							if(map.containsKey(board[a][b])) {
								return false;
							}
							
							map.put(board[a][b], 1);
							
						}
					}
				}
			}
		}
			
		return true;
    }
}
