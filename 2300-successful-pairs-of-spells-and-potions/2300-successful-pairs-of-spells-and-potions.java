import java.util.Arrays;
import java.util.ArrayList;

class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        ArrayList<Integer> arr = new ArrayList<>();
        int i = 0;

        while (i < spells.length) {
            int idx = potions.length;
            long required = (success + spells[i] - 1) / spells[i]; 

            int l = 0, r = potions.length - 1;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (potions[mid] >= required) {
                    idx = mid;
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }

            arr.add(potions.length - idx);
            i++;
        }

        int[] ans = new int[arr.size()];
        for (int k = 0; k < arr.size(); k++) {
            ans[k] = arr.get(k);
        }

        return ans;
    }
}