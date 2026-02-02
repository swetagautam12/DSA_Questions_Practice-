class Solution {
    public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        Queue<List<Integer>> queue = new LinkedList<>();
        queue.add(Arrays.asList(0, 0));

        Set<List<Integer>> visited = new HashSet<>();
        while(!queue.isEmpty()){
            List<Integer> values = queue.poll();
            if(visited.contains(values)){
                continue;
            }
            int jug1 = values.get(0);
            int jug2 = values.get(1);
            visited.add(values);

            if(Stream.of(jug1, jug2, jug1 + jug2, jug1 + jug2Capacity, jug2Capacity + jug1).anyMatch(v->v==targetCapacity))
                return true;

            queue.add(Arrays.asList(Math.min(jug2 + jug1, jug1Capacity), 0));
            queue.add(Arrays.asList(0, Math.min(jug2 + jug1, jug2Capacity)));
            queue.add(Arrays.asList(Math.abs(jug2Capacity - jug1), 0));
            queue.add(Arrays.asList(0, Math.abs(jug1Capacity - jug2)));
        }
  
        return false;
    }
}