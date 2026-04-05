class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() <= 1){
            return s.length();
        }
        int res = 1;
        int index = 0;
        while(index < s.length()-1){
            HashSet<Character> set = new HashSet<>();
            set.add(s.charAt(index));
            int i = index+1;
            while(i<=s.length()-1 && set.size() == i-index){
                set.add(s.charAt(i));
                i++; 
            }
            if(set.size() > res){
                res = set.size();
            }
            //set.clear();
            index = (i-index == set.size()) ? s.length()-1 : index + (s.substring(index,i-1)).indexOf(s.charAt(i-1)) + 1;
            //index = index + (s.substring(index,i-1)).indexOf(s.charAt(i-1)) + 1;
        }
        return res;
    }
}
