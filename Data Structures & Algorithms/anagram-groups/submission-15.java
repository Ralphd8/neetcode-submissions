class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<>();
        for(String s : strs){
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String str = "";
            for(char c : arr){
                str = str + String.valueOf(c);
            }
            if(map.containsKey(str)){
                map.get(str).add(s);
            }
            else{
                map.put(str,new ArrayList<>(List.of(s)));
            }
        }
        List<List<String>> res = new ArrayList<>();
        for(String s : map.keySet()){
            res.add(map.get(s));
        }
        return res;
    }
}
