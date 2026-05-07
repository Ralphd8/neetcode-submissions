class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<>();
        for(String s : strs){
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String str = new String(arr);
            map.putIfAbsent(str,new ArrayList<>());
            map.get(str).add(s);
        }
        List<List<String>> res = new ArrayList<>();
        for(String s : map.keySet()){
            res.add(map.get(s));
        }
        return res;
    }
}
