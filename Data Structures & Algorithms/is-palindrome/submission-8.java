class Solution {
    public boolean isDigitOrLetter(char c){
        if((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9')){
            return true;
        }
        else{
            return false;
        }
    }
    public boolean isPalindrome(String s) {
        String x = s.toLowerCase();
        int start = 0;
        int end = s.length()-1;
        while(start<end){
            if(isDigitOrLetter(x.charAt(start)) == false){
                start++;
            }
            else if(isDigitOrLetter(x.charAt(end)) == false){
                end--;
            }
            else if(x.charAt(start) != x.charAt(end)){
                return false;
            }
            else{
                start++;
                end--;
            }
        }
        return true;
    }
}
