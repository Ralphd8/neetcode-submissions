class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i = 0 ; i<s.length();i++){
            char cur = s.charAt(i);
            if(map.containsKey(cur)){
                int qty = map.get(cur);
                qty++;
                map.put(cur,qty);
            }
            else{
                map.put(cur,1);
            }
        }
        for(int i = 0;i<t.length();i++){
            char cur = t.charAt(i);
            if(!map.containsKey(cur)){
                return false;
            }
            else if(map.get(cur) == 1){
                map.remove(cur);
            }
            else{
                int qty = map.get(cur);
                qty--;
                map.put(cur,qty);
            }
        }
        if(map.size() == 0){
            return true;
        }
        else{
            return false;
        }
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();

        for (String s : strs){
            boolean added = false;
            for(List<String> list : res){
                String comparison = list.get(0);
                if(isAnagram(s,comparison) == true){
                    list.add(s);
                    added = true;
                    break;
                }
            }
            if (added == false){
                List<String> l = new ArrayList<>();
                l.add(s);
                res.add(l);
            }
        }

        return res;
    }
}
