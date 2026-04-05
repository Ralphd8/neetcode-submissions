class Solution {
    public static boolean check(String s1,String s2){
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i =0;i<s1.length();i++){
            char c = s1.charAt(i);
            if(map.containsKey(c)){
                map.put(c,map.get(c)+1);
            }
            else{
                map.put(c,1);
            }
        }
        for(int i=0;i<s2.length();i++){
            char c = s2.charAt(i);
            if(!map.containsKey(c)){
                return false;
            }
            else if(map.containsKey(c) && map.get(c) > 1){
                map.put(c,map.get(c)-1);
            }
            else{
                map.remove(c);
            }
        }
        if(map.size()==0){
            return true;
        }
        else{
            return false;
        }
    }
    public boolean checkInclusion(String s1, String s2) {
        if(s2.length() < s1.length()){
            return false;
        }
        int ws = s1.length();
        for(int i=0;i<=s2.length()-ws;i++){
            if(check(s1,s2.substring(i,i+ws)) == true){
                return true;
            }
            if(i == s2.length()-ws && check(s1,s2.substring(i,i+ws)) == false){
                return false;
            }
        }
        return false;
    }
}
