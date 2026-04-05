class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        intermediate(n,list,0,0,"");
        return list;
    }
    public void intermediate(int n,List<String> list, int open,int close,String s){
        if(open == n && close == n){
            list.add(s);
            return;
        }
        if(open == close){
            intermediate(n,list,open+1,close,s+"(");
        }
        else{
            if(open < n){
                intermediate(n,list,open+1,close,s+"(");
            }
            intermediate(n,list,open,close+1,s+")"); 
        }
    }
}
