class Solution {
public:
    int smallestNumber(int n) {
        long long k = 1;
        while (true) {
            long long val = (1LL << k) - 1;
            if (val >= n) return (int)val;
            k++;
        }
    }
};