class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int item : nums){
            if (map.containsKey(item)){
                map.put(item,map.get(item)+1);
            }
            else{
                map.put(item,1);
            }
        }
        int maxOccurance = 0;
        for (int i = 0 ; i<=k-1;i++){
            int integerWithMaxOccu = 0;
            for(Integer Key : map.keySet()){
                if (map.get(Key) > maxOccurance){
                    maxOccurance = map.get(Key);
                    integerWithMaxOccu = Key;
                }
            }
            res[i] = integerWithMaxOccu;
            maxOccurance = 0;
            map.remove(integerWithMaxOccu);
        }
        return res;
    }
}
