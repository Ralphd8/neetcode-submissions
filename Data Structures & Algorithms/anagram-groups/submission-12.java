class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character,Integer> smap = new HashMap<>();
		HashMap<Character,Integer> tmap = new HashMap<>();
		for (int i = 0 ;i<s.length();i++) {
			if(smap.containsKey(s.charAt(i))) {
				int qty  = smap.get(s.charAt(i));
				qty++;
				smap.put(s.charAt(i), qty);
			}
			else {
				smap.put(s.charAt(i), 1);
			}
		}
		for (int i = 0 ;i<t.length();i++) {
			if(tmap.containsKey(t.charAt(i))) {
				int qty  = tmap.get(t.charAt(i));
				qty++;
				tmap.put(t.charAt(i), qty);
			}
			else {
				tmap.put(t.charAt(i), 1);
			}
		}
		for(char c : smap.keySet()) {
			if(!tmap.containsKey(c)) {
				return false;
			}
			if(smap.get(c) != tmap.get(c)) {
				return false;
			}
		}
		for(char c : tmap.keySet()) {
			if(!smap.containsKey(c)) {
				return false;
			}
			if(tmap.get(c) != smap.get(c)) {
				return false;
			}
		}
		return true;
    }
    
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
		if(strs.length == 0) {
			return res;
		}
		
		for(int i =0 ;i<strs.length;i++) {
			if(i == 0) {
				List<String> list = new ArrayList<>();
				list.add(strs[i]);
				res.add(list);
			}
			else {
				boolean added = false;
				for(List<String> list : res) {
					Iterator<String> it = list.iterator();
					if(isAnagram(it.next(),strs[i]) == true) {
						list.add(strs[i]);
						added = true;
						break;
					}
				}
				
				if(added == true) {
					continue;
				}
				else {
					List<String> list = new ArrayList<>();
					list.add(strs[i]);
					res.add(list);
				}
			}
		}
		return res;
    }
}
