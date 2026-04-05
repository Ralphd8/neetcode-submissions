class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        inter(res,0,0,"",n);
        return res;
    }

    public void inter(List<String> res, int left,int right,String s,int n){
        if(s.length() == 2*n){
            res.add(s);
            return;
        }
        if(left < n){
            inter(res,left+1,right,s+"(",n);
        }
        if(right < left && right < n){
            inter(res,left,right+1,s+")",n);
        }
    }
}
