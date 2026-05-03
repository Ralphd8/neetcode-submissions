class MedianFinder {
    Comparator<Integer> comp = new Comparator<>(){
        public int compare(Integer a, Integer b){
            return a-b;
        }
    };
    List<Integer> list = new ArrayList<>();

    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        list.add(num);
    }
    
    public double findMedian() {
        Collections.sort(list,comp);
        boolean even = list.size() % 2 == 0;
        double res = 0.0;
        if(even){
            res = ((double) list.get(list.size()/2) + (double) list.get(list.size()/2-1)) / 2.0;
        }
        else{
            res = list.get(list.size()/2);
        }
        return res;
    }
}
