class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i =0; i<nums.length ; i++){
            if(map.containsKey(nums[i])){
                int qty = map.get(nums[i]);
                qty++;
                map.put(nums[i],qty);
            }
            else{
                map.put(nums[i],1);
            }
        }
        for (int i = 0 ;i<k;i++){
            int max = -1;
            for (Integer j : map.keySet()) {
                if(map.get(j) > max){
                    res[i] = j;
                    max =map.get(j);
                }
            }
            map.remove(res[i]);    
        }
        return res;
    }
}
