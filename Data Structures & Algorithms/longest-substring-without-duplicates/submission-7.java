class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0 || s.length() == 1){
            return s.length();
        } 
        HashMap<Character,Integer> map = new HashMap<>();
        int max = 1;
        int index = 0;
        while(index != s.length()){
            if(!map.containsKey(s.charAt(index))){
                map.put(s.charAt(index),index);
                if(index == s.length()-1){
                    if(map.size() > max){
                        max = map.size();
                    } 
                }
            }
            else{
                if(map.size() > max){
                    max = map.size();
                }
                int i = map.get(s.charAt(index));
                Iterator<Character> it = map.keySet().iterator();
                while(it.hasNext()){
                    if(map.get(it.next()) <= i){
                        it.remove();
                    }
                }
                map.put(s.charAt(index),index);
            }
            index++;
        }

        return max;
    }
}
