class Solution {
public:
    int numWaterBottles(int numBottles, int numExchange) {
        
        int ans = numBottles;

        while(numBottles >= numExchange)
        {
            int rem = numBottles%numExchange;
            int toDrink = numBottles / numExchange;

            ans += toDrink;

            numBottles = rem + toDrink;
        }
        return ans;
    }
};