class TimeMap {
    HashMap<String,HashMap<String,Integer>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        for (String s : map.keySet()) {
        	if(s.equals(key)) {
        		HashMap<String,Integer> val = map.get(s);
        		val.put(value,timestamp);
        		map.put(s,val);
        		return;
        	}	
        	
        }
        HashMap<String,Integer> val = new HashMap<>();
        val.put(value, timestamp);
        map.put(key, val);
            
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) {
        	return "";
        }
        HashMap<String,Integer> val = map.get(key);
        
        String res = "";
        int time =-1;
        int qty = 0;
        for(String s : val.keySet()) {
        	if(val.get(s) <= timestamp && qty == 0) {
        		res = s;
        		time = val.get(s);
        		qty++;
        		continue;
        	}
        	if(val.get(s) <= timestamp && qty != 0 && val.get(s) > time) {
        		res = s;
        		time = val.get(s);
        		qty++;
        		continue;
        	}
        }
        
        return res;
    }
}
