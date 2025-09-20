class Solution {
public:
    double myPow(double x, int n) {
        // Handle negative exponents with overflow protection
        if (n < 0) {
            if (n == INT_MIN) {
                return 1.0 / (myPow(x, INT_MAX) * x);
            }
            return 1.0 / myPow(x, -n);
        }
        
        // Base case
        if (n == 0) {
            return 1.0;
        }
        
        // Divide and conquer: compute x^(n/2)
        double half = myPow(x, n / 2);
        
        // Even exponent: x^n = (x^(n/2))^2
        if (n % 2 == 0) {
            return half * half;
        } else {
            // Odd exponent: x^n = (x^(n/2))^2 * x
            return half * half * x;
        }
    }
};