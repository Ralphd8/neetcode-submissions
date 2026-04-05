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
	
	/*public static int check(List<List<String>> list) {
		int sum = 0;
		if(list.size() == 0) {
			return sum;
		}
		for(int i =0 ;i<list.size();i++) {
			sum = sum + list.get(i).size();
		}
		return sum;
	}*/
	
	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> res = new ArrayList<>();
		
		if(strs.length == 0) {
			return res;
		}
		
		HashMap<String,List<String>> map = new HashMap<>();
		String[] entered = new String[strs.length];
		for (int i = 0 ;i<entered.length ; i++) {
			entered[i] = "not entered";
		}
		for (int i = 0 ; i<strs.length;i++) {
			if(i == 0) {
				List<String> list = new ArrayList<>();
				list.add(strs[i]);
				map.put(strs[i], list);
				entered[i] = "enter";
			}
			else {
				for(String s : map.keySet()) {
					if(isAnagram(s,strs[i])) {
						List<String> list = map.get(s);
						list.add(strs[i]);
						map.put(s, list);
						entered[i] = "enter";
						break;
					}
				}
				if(!entered[i].equals("enter")) {
					List<String> list = new ArrayList<>();
					list.add(strs[i]);
					map.put(strs[i], list);
				}
				
				
			}	
			
		}
		for(String s : map.keySet()) {
			res.add(map.get(s));
		}
		return res;
		
    }
}
