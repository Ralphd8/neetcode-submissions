class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0 || s.length() == 1){
            return s.length();
        }
        HashMap<Character,Integer> map = new HashMap<>();
        int left = 0;
        int right = 1;
        int count = 1;
        map.put(s.charAt(left),left);

        while(right != s.length()){
            char c = s.charAt(right);
            if(!map.containsKey(c)){
                map.put(c,right);
                right++;
                if(right == s.length()){
                    count = Math.max(count,right-left);
                }
            }
            else{
                count = Math.max(count,right-left);
                if(map.get(c) >= left){
                    left = map.get(c) + 1;
                }
                map.put(c,right);
                right++;
            }
        }

        return count;
    }
}
