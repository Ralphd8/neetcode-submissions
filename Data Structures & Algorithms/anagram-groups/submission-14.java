class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i = 0;i<= s.length()-1;i++){
            if(map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),map.get(s.charAt(i))+1);
            }
            else{
                map.put(s.charAt(i),1);
            }
        }
        for (int i = 0;i<= t.length()-1;i++){
            if(map.containsKey(t.charAt(i)) && map.get(t.charAt(i))>1){
                map.put(t.charAt(i),map.get(t.charAt(i))-1);
            }
            else if(map.containsKey(t.charAt(i)) && map.get(t.charAt(i))==1){
                map.remove(t.charAt(i));
            }
            else{
                return false;
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
		for (int i = 0; i < strs.length; i++) {
			if(res.isEmpty()){
				List<String> subList = new ArrayList<>();
				subList.add(strs[i]);
				res.add(subList);
			}
			else{
				boolean added = false;
				for(List<String> subList : res){
					if(isAnagram(subList.get(0),strs[i])){
						subList.add(strs[i]);
						added = true;
						break;
					}
				}
				if (added == false){
					List<String> subList = new ArrayList<>();
					subList.add(strs[i]);
					res.add(subList);
				}
			}
		}
		return res;
    }
}
