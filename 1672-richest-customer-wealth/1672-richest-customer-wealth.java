class Solution {
    public int maximumWealth(int[][] accounts) {
        int maxWealth = 0;
        for (int[] customers : accounts) {
            int amount = 0;
            for(int account : customers){
                amount += account;
            }
            if (amount > maxWealth)
                maxWealth = amount;
        }
        return maxWealth;
    }
}