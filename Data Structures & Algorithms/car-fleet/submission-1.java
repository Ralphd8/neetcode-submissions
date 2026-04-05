class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        if(position.length == 1 || position.length == 0) {
			return position.length;
		}
		for(int i = 0;i<position.length-1;i++) {
			for(int j = 0;j<position.length-1-i;j++) {
				if(position[j] < position[j+1]) {
					int temp = position[j];
					position[j] = position[j+1];
					position[j+1] = temp;
					
					int temp1 = speed[j];
					speed[j] = speed[j+1];
					speed[j+1] = temp1;
				}
			}
		}
		
		int count =1;
		int pointer = 0;
		for(int i =1;i<position.length;i++) {
			double t = target;
			double posCur = position[i];
			double posPrev = position[pointer];
			double sCur = speed[i];
			double sPrev = speed[pointer];
			
			double curT = (t-posCur) / sCur;
			double prevT = (t - posPrev) / sPrev;
			
			if(curT > prevT) {
				count++;
				pointer = i;
			}
		}
		return count;
    }
}
