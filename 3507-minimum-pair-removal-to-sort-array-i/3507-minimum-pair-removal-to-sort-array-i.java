class Solution {

    public int minimumPairRemoval(int[] nums) {
        if (nums.length <= 1)
            return 0;

        List<Integer> list = new ArrayList<>();
        for (int n : nums)
            list.add(n);

        int operations = 0;

        while (list.size() > 1 && !isSorted(list)) {
            int minIndex = findMinPairIndex(list);

            list.set(minIndex, list.get(minIndex) + list.get(minIndex + 1));
            list.remove(minIndex + 1);

            operations++;
        }

        return operations;
    }

    private boolean isSorted(List<Integer> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) > list.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    private int findMinPairIndex(List<Integer> list) {
        int minIndex = 0;
        int minSum = list.get(0) + list.get(1);

        for (int i = 1; i < list.size() - 1; i++) {
            int currSum = list.get(i) + list.get(i + 1);
            if (currSum < minSum) {
                minSum = currSum;
                minIndex = i;
            }
        }
        return minIndex;
    }
}