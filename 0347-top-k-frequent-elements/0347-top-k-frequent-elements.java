class Solution {
    public int[] topKFrequent(int[] nums, int k) {
    HashMap<Integer,Integer> tem=new HashMap<>();
    for(int i:nums){
        tem.put(i,tem.getOrDefault(i,0)+1);
    }
    PriorityQueue<Map.Entry<Integer,Integer>> pq=new PriorityQueue<>(
        (a,b)->b.getValue()-a.getValue()
    );
    for(Map.Entry<Integer,Integer> e:tem.entrySet()){
        pq.offer(e);
    }
    int[] res=new int[k];
    for(int i=0;i<k;i++){
        res[i]=pq.poll().getKey();
    }
    return res;
    }
}