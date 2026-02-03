class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        String newStr1="";
        String newStr2="";
        for(String str : word1){
            newStr1+=str;
        }
        for(String str : word2){
            newStr2+=str;
        }
        return newStr1.equals(newStr2);
    }
}