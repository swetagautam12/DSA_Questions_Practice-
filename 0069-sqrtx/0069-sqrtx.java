class Solution {
    
    public int sqrt_for_loop(int target) {
        if (target < 0) return -1;

        for (int i = 0; i <= target; i++) {
            if (i * i == target) return i;
            else if (i * i > target) return i - 1;
        }
        return -1;
    }

 
    public int sqrt_while_loop(int target) {
        if (target < 2) return target;

        int i = 1;
        while (i <= target / i) {
            i++;
        }
        return i - 1;
    }

   
    public int sqrt_binary_search(int target) {
        if (target < 2) return target;

        int start = 1, end = target / 2;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            long square = (long) mid * mid;

            if (square == target) return mid;
            else if (square < target) start = mid + 1;
            else end = mid - 1;
        }
        return end;
    }

    
    public int sqrt_newton(int target) {
        if (target == 0) return 0;

        long x = target;
        while (x * x > target) {
            x = (x + target / x) / 2;
        }
        return (int) x;
    }

 
    public int mySqrt(int target) {
        return sqrt_newton(target); 
}