class Solution {
public:
    int maxBottlesDrunk(int numBottles, int numExchange) {
        int drunk = numBottles;
        while(numBottles >= numExchange){
            numBottles = numBottles - numExchange + 1;
            drunk++;
            numExchange++;
        }
        return drunk;
    }
};