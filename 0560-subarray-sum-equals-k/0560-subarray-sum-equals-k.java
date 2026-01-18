class Solution {
    public int subarraySum(int[] arr, int k) {
        HashMap<Integer , Integer> prefixSum = new HashMap<>();
        prefixSum.put(0,1);
        int sum =0 , count=0;
        for(int i =0; i<arr.length;i++){
            sum += arr[i];
            int exp =sum -k ;
            count += prefixSum.getOrDefault(exp,0);
            prefixSum.put(sum , prefixSum.getOrDefault(sum , 0)+1);

        }
        return count ;
        
    }
}