class Solution {
	
	public static int minEatingSpeed(int[] piles, int h) {
		int left = 1;
		int right = 1;
		
		for(int pile : piles) {
			if(pile > right) {
				right = pile;
			}
		}
		
		while(left<right) {
			int mid = (left+right)/2;
			double m = mid;
			double res = 0;
			
			for(int pile : piles) {
				double p = pile;
				res = res + Math.ceil(p/m);
			}
			int r = (int) res;
			 
			if(r<= h) {
				right = mid;
			}
			else {
				left = mid+1;
			}
		}
		
		return right;
    }
}
