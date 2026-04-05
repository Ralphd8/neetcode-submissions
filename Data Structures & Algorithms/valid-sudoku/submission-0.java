class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashMap<Character,Integer> map = new HashMap<>();
        
        for (int i = 0 ;i<board.length;i++) {
        	for(int j = 0 ; j<board[0].length ; j++) {
        		if(board[i][j] == '1' || board[i][j] == '2' || board[i][j] == '3' || board[i][j] == '4' || board[i][j] == '5' || board[i][j] == '6' || board[i][j] == '7' || board[i][j] == '8' || board[i][j] == '9' ) {
        			if(map.containsKey(board[i][j])) {
        				int qty = map.get(board[i][j]);
        				qty++;
        				map.put(board[i][j], qty);
        			}
        			else {
        				map.put(board[i][j], 1);
        			}
        		}
        	}
        	for(char c : map.keySet()) {
        		if(map.get(c)>1) {
        			return false;
        		}
        	}
        	map.clear();
        }
        
        for (int j = 0 ;j<board[0].length;j++) {
        	for(int i = 0 ; i<board.length ; i++) {
        		if(board[i][j] == '1' || board[i][j] == '2' || board[i][j] == '3' || board[i][j] == '4' || board[i][j] == '5' || board[i][j] == '6' || board[i][j] == '7' || board[i][j] == '8' || board[i][j] == '9' ) {
        			if(map.containsKey(board[i][j])) {
        				int qty = map.get(board[i][j]);
        				qty++;
        				map.put(board[i][j], qty);
        			}
        			else {
        				map.put(board[i][j], 1);
        			}
        		}
        	}
        	for(char c : map.keySet()) {
        		if(map.get(c)>1) {
        			return false;
        		}
        	}
        	map.clear();
        }
        for(int z=0 ; z<=6;z=z+3) {
        for(int k = 0 ;k<=6;k=k+3) {
        	for(int i=0+z;i<=2+z;i++) {
        		for(int j=0+k;j<=2+k;j++) {
        			if(board[i][j] == '1' || board[i][j] == '2' || board[i][j] == '3' || board[i][j] == '4' || board[i][j] == '5' || board[i][j] == '6' || board[i][j] == '7' || board[i][j] == '8' || board[i][j] == '9' ) {
            			if(map.containsKey(board[i][j])) {
            				int qty = map.get(board[i][j]);
            				qty++;
            				map.put(board[i][j], qty);
            			}
            			else {
            				map.put(board[i][j], 1);
            			}
            		}
        		}
        		
        	}
        	for(char c : map.keySet()) {
        		if(map.get(c)>1) {
        			return false;
        		}
        	}
        	map.clear();
        }
        }
        
        
        
        
        
        return true;    
    }
}
