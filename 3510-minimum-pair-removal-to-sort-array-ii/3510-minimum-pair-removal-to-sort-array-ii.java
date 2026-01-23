class Solution {
    class Store{
        int id;
        int flg;
        long leftVal;
        long rightVal;
        Store prev;
        Store next;
        public Store(int id, int flg, long leftVal, long rightVal, Store prev, Store next){
            this.id = id;
            this.flg = flg;
            this.leftVal = leftVal;
            this.rightVal = rightVal;
            this.prev = prev;
            this.next = next;
        }
    }
    public int minimumPairRemoval(int[] nums) {
        int len = nums.length;
        if(len == 1) return 0;
        HashMap<Long, TreeSet<Integer>> sumOrd = new HashMap<>();
        HashMap<Integer, Store> storeMap = new HashMap<>();
        PriorityQueue<Long> pq = new PriorityQueue<>();
        Set<Integer> set = new HashSet<>();

        int flg = nums[0] > nums[1] ? 1 : 0;
        Store prev = new Store(0, flg, nums[0], nums[1], null, null);
        storeMap.put(0, prev);
        long sum = nums[0]+nums[1];
        sumOrd.put(sum, new TreeSet<>());
        sumOrd.get(sum).add(0);
        pq.add(sum);

        int cntWr = flg;
        for(int i = 1;i < len-1;i++){

            flg = nums[i] > nums[i+1] ? 1 : 0;
            Store curr = new Store(i, flg, nums[i], nums[i+1], prev, null);
            curr.prev.next = curr;
            storeMap.put(i, curr);

            sum = nums[i]+nums[i+1];
            if(!sumOrd.containsKey(sum)) sumOrd.put(sum, new TreeSet<>());
            sumOrd.get(sum).add(i);
            pq.add(sum);

            prev = curr;
            cntWr += flg;
        }

        int ans = 0;
        while(!pq.isEmpty() && cntWr > 0){
            long ele = pq.poll();
            if(!sumOrd.containsKey(ele)){
                continue;
            }
            if(sumOrd.get(ele).isEmpty()){
                sumOrd.remove(ele);
                continue;
            }
            int id = sumOrd.get(ele).pollFirst();
            if(set.contains(id)) continue;
            Store cur = storeMap.get(id);
            cur.leftVal = cur.leftVal+cur.rightVal;

            if(cur.prev != null){
                long prevSum = cur.prev.leftVal+cur.prev.rightVal;
                cur.prev.rightVal = cur.leftVal;
                if(cur.prev.flg == 1 && cur.prev.leftVal <= cur.prev.rightVal){
                    cur.prev.flg = 0;
                    cntWr--;
                }
                if(cur.prev.flg == 0 && cur.prev.leftVal > cur.prev.rightVal){
                    cntWr++;
                    cur.prev.flg = 1;
                }

                sum = cur.prev.leftVal+cur.prev.rightVal;
                int tempId = cur.prev.id;
                sumOrd.get(prevSum).remove(tempId);
                if(!sumOrd.containsKey(sum)) sumOrd.put(sum, new TreeSet<>());
                sumOrd.get(sum).add(tempId);
                pq.add(sum);
            }

            if(cur.next != null){
                cur.rightVal = cur.next.rightVal;
                if(cur.flg == 1 && cur.leftVal <= cur.rightVal){
                    cur.flg = 0;
                    cntWr--;
                }
                if(cur.flg == 0 && cur.leftVal > cur.rightVal){
                    cur.flg = 1;
                    cntWr++;
                }

                sum = cur.rightVal + cur.leftVal;
                if(!sumOrd.containsKey(sum)) sumOrd.put(sum, new TreeSet<>());
                sumOrd.get(sum).add(id);
                pq.add(sum);

                if(cur.next.next != null){
                    cur.next.next.prev = cur;
                }

                if(cur.next.flg == 1) cntWr--;

                set.add(cur.next.id);
                cur.next = cur.next.next;
            }
            else if(cur.prev != null){
                if(cur.flg == 1) cntWr--;
                set.add(cur.id);
                cur.prev.next = null;
            }
            ans++;
        }

        return ans;
    }
}