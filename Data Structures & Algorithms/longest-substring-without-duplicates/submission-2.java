class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0 || s.length() == 1) {
			return s.length();
		}
        int i=0 , j =i , max =0;
        HashSet<Character> set = new HashSet<>();
        set.add(s.charAt(i));
        while(j != s.length()-1) {
        	
        	while(set.size() == j-i+1 && j != s.length()-1) {
        		j++;
        		set.add(s.charAt(j));
        	}
        	
        	
        	
        	if(set.size() > max) {
        		max = set.size();
        	}
        	
        	if(j == s.length()-1) {
        		break;
        	}
        	
        	while(s.charAt(i) != s.charAt(j)) {
        		i++;
        	}
        	if(s.charAt(i) == s.charAt(j)) {
        		i++;
        	}
        	
        	j = i;
        	set.clear();
        	set.add(s.charAt(i));
        	
        	
        }
        
        return max;
    }
}
