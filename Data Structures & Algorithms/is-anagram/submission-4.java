class Solution {
    public boolean isAnagram(String s, String t) {
         if(s.length() != t.length()) {
			return false;
		}
		HashMap<Character,Integer> map1 = new HashMap<>();
		HashMap<Character,Integer> map2 = new HashMap<>();
		
		for(int i = 0 ; i<s.length(); i++) {
			if(map1.containsKey(s.charAt(i))) {
				int qty = map1.get(s.charAt(i));
				qty++;
				map1.put(s.charAt(i), qty);
			}
			else {
			map1.put(s.charAt(i), 1);
			}
		}
		for(int i = 0 ; i<t.length(); i++) {
			if(map2.containsKey(t.charAt(i))) {
				int qty = map2.get(t.charAt(i));
				qty++;
				map2.put(t.charAt(i), qty);
			}
			else {
			map2.put(t.charAt(i), 1);
			}
		}
		
		if(map1.size() != map2.size()) {
			return false;
		}
		for (char i : map1.keySet()) {
			if(!map2.containsKey(i)) {
				return false;
			}
			if(map1.get(i) != map2.get(i)) {
				//return false;
			}
		}
		for (char i : map2.keySet()) {
			if(!map1.containsKey(i)) {
				return false;
			}
			if(map2.get(i) != map1.get(i)) {
				return false;
			}
		}
		return true;
    }
}
