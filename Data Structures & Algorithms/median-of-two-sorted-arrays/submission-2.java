class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        ArrayList<Integer> array = new ArrayList<>();
        for(Integer i : nums1){
             array.add(i);
        }
        for(Integer i : nums2){
            array.add(i);
        }
        Collections.sort(array);
        if(array.size()%2==0){
            double x = array.get(array.size()/2);
            double y = array.get(array.size()/2 -1);
            double res = (x+y)/2;
            return res;
        }
        else{
            return (double) array.get(array.size()/2);
        }
    }
}
