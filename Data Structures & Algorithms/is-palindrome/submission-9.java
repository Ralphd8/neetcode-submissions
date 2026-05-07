class Solution {
    public boolean isPalindrome(String s) {
        String st = s.toLowerCase();
        int left = 0;
        int right = s.length()-1;
        while(left<right){
            char l = st.charAt(left);
            char r = st.charAt(right);
            if(!((l <= '9' && l >= '0') || (l <= 'z' && l >= 'a'))){
                left++;
            }
            else if(!((r <= '9' && r >= '0') || (r <= 'z' && r >= 'a'))){
                right--;
            }
            else if(l != r){
                return false;
            }
            else{
                left++;
                right--;
            }
        }
        return true;
    }
}
