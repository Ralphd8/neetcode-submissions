class MedianFinder {
    PriorityQueue<Integer> min = new PriorityQueue<>();
    //PriorityQueue<Integer> max = new PriorityQueue<>((a,b) -> b-a);
    PriorityQueue<Integer> max = new PriorityQueue<>(new Comparator<Integer>(){
                                                            public int compare(Integer a,Integer b){
                                                                return b-a;
                                                            }
                                                        });

        
    

    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        if(min.size() == 0 && max.size() == 0){max.add(num);}
        else if(min.size() == max.size()-1 && num <= max.peek()){
            max.add(num);
            min.add(max.poll());
        }
        else if(min.size() == max.size()-1 && num > max.peek()){
            min.add(num);
        }
        else if(min.size() == max.size() && num <= max.peek()){
            max.add(num);
        }
        else{
            min.add(num);
            max.add(min.poll());
        }
    }
    
    public double findMedian() {
        if(max.size() > min.size()){
            return (double) max.peek();
        }
        else{
            return ((double) min.peek() + (double) max.peek()) / 2.0;
        }
    }
}
