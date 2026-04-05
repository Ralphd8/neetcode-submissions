class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0 ; i<nums.length;i++) {
        	if (map.containsKey(nums[i])) {
        		int qty = map.get(nums[i]);
        		qty = qty +1;
        		map.put(nums[i], qty);
        	}
        	else {
        		map.put(nums[i], 1);
        	}
        	
        }
        int[] res = new int[k];
        
        ArrayList<Integer> array = new ArrayList<>();
        int mapSize = map.size();
        for (int i = 1 ; i<= mapSize;i++) {
        	int occurance = 0;
        	int maxNum = -1;
        	for(int j : map.keySet()) {
        		if(map.get(j) >= occurance) {
        			occurance = map.get(j);
        			maxNum = j;
        		}
        	}
        	array.add(maxNum);
        	map.remove(maxNum);
        }
        
        Iterator<Integer> it = array.iterator();
        for(int i = 0 ;i<= k-1;i++) {
        	res[i] = it.next();
        }
        
        return res;
    }
}
