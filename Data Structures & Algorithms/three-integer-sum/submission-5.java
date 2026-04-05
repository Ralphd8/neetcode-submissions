class Solution {
    public void bubbleSort(List<Integer> list){
        for(int i=0 ; i<list.size();i++){
            for(int j=0;j<list.size()-1-i;j++){
                if(list.get(j) > list.get(j+1)){
                    int temp = list.get(j);
                    list.set(j, list.get(j+1));
                    list.set(j+1 , temp); 
                }
            }
        }
    }
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        HashSet<List<Integer>> hash = new HashSet<>();

        for(int i = 0;i<nums.length-2;i++){
            for(int j=i+1; j<nums.length-1;j++){
                for(int k = j+1;k<nums.length;k++){
                    if(nums[i] + nums[j] + nums[k] == 0){
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        bubbleSort(list);
                        hash.add(list);
                    }
                }
            }
        }
        for(List<Integer> list : hash){
            res.add(list);
        }
        return res;
    }
}
