class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() == 0 || s2.length() == 0 || s2.length() < s1.length()){
            return false;
        }
        char[] arr = s1.toCharArray();
        Arrays.sort(arr);
        String s = new String(arr);

        for(int i =0;i<s2.length()-s1.length()+1;i++){
            char[] cur = s2.substring(i,i+s1.length()).toCharArray();
            Arrays.sort(cur);
            String current = new String(cur);
            if(current.equals(s)){
                return true;
            }
        }
        return false;
    }
}
