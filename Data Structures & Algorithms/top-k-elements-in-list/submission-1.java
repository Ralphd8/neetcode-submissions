class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i =0 ;i<nums.length ;i++) {
        	if(map.containsKey(nums[i])) {
        		int qty = map.get(nums[i]);
        		qty++;
        		map.put(nums[i],qty);
        	}
        	else {
        		map.put(nums[i], 1);
        	}
        }
        int max = 0;
        int element = 0;
        for(int i=0;i<=k-1;i++) {
        	for(int key : map.keySet()) {
        		if(map.get(key)> max) {
        			max = map.get(key);
        			element = key;
        		}
        	}
        	res[i] = element;
        	map.remove(element);
        	max = 0;
        	element = 0;
        }
        return res;
    }
}
