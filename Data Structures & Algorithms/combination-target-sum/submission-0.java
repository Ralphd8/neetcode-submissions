class Solution {
    public int sum(List<Integer> list){
        if(list == null){return 0;}
        int sum = 0;
        for(Integer i : list){sum = sum + i;}
        return sum;
    }
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> subList = new ArrayList<>();
        List<List<Integer>> inter = new ArrayList<>(list);
        inter.add(subList);

        while(inter.size() != 0){
            List<List<Integer>> inter1 = new ArrayList<>(inter);
            for(List<Integer> l : inter1){
                if(sum(l) == target){
                    list.add(l);
                    inter.remove(l);
                    continue;
                }
                for(int i =0 ;i<nums.length;i++){
                    boolean goToNextIte = false;
                    if(i != nums.length-1){
                        for(int j = i+1;j<nums.length;j++){
                            if(l.contains(nums[j])){
                                goToNextIte = true;
                            }
                        }
                    }
                    if(goToNextIte == true){continue;}
                    List<Integer> newL = new ArrayList<>(l);
                    newL.add(nums[i]);
                    if(sum(l) <= target){
                        inter.add(newL);
                    }

                }
                inter.remove(l);
            }
        }
        return list;
    }
}
