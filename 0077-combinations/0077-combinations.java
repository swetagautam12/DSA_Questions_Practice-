class Solution {
    public List<List<Integer>> combine(int n, int k) {
        return combinations(new ArrayList<>(), k, n, 1);
    }

 

    List<List<Integer>> combinations(List<Integer> currentCombination, int k, int n, int index){
        if(k == 0){
            List<List<Integer>> list = new ArrayList<>();
            list.add(new ArrayList<>(currentCombination));
            return list;
        }

        List<List<Integer>> result = new ArrayList<>();

        for (int i = index; i <= n; i++){
            currentCombination.add(i);
            result.addAll(combinations(currentCombination, k-1, n, i+1));
            currentCombination.removeLast();
        }

        return result;
    }
    
}