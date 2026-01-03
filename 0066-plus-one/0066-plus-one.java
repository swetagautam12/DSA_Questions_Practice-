class Solution {
    public int[] plusOne(int[] digits) {
    
    for (int position = digits.length - 1; position >= 0; position--) {
        if (digits[position] < 9) {
            digits[position]++;
            
            return digits;
        }
        
        digits[position] = 0; 
    }
    
    int[] incrementedArray = new int[digits.length + 1];
    incrementedArray[0] = 1;
    return incrementedArray;
        
    }
}