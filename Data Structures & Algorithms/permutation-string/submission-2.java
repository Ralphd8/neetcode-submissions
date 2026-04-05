class Solution {
    public static boolean permutation(String s1, String s2) {
		if(s1.length() != s2.length()) {
			return false;
		}
		HashMap<Character,Integer> set1 = new HashMap<>();
		HashMap<Character,Integer> set2 = new HashMap<>();
		
		for(int i = 0;i<s1.length();i++) {
			if(set1.containsKey(s1.charAt(i))) {
				int qty = set1.get(s1.charAt(i));
				qty++;
				set1.put(s1.charAt(i), qty);
			}
			else {
				set1.put(s1.charAt(i), 1);
			}
		}
		for(int i = 0;i<s1.length();i++) {
			if(set2.containsKey(s2.charAt(i))) {
				int qty = set2.get(s2.charAt(i));
				qty++;
				set2.put(s2.charAt(i), qty);
			}
			else {
				set2.put(s2.charAt(i), 1);
			}
		}
		
		if(set1.size() != set2.size()) {
			return false;
		}
		else {
			for (char c : set1.keySet()) {
				if(!set2.containsKey(c) || set2.get(c) != set1.get(c)) {
					return false;
				}
			}
		}
		return true;
		
	}
    public boolean checkInclusion(String s1, String s2) {
        if(s2.length() < s1.length()) {
        	return false;
        }
        int i=0;
        int j=i+s1.length();
        while(j != s2.length()+1) {
        	if(permutation(s1,s2.substring(i,j)) == true) {
        		return true;
        	}
        	i++;
        	j++;
        }
        return false;
    }
}
