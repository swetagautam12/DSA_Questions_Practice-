class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        if(n==0){
            return 0;

        }
        int [][] cars =new int[n][2];
        for(int i =0; i <n;i++){
            cars[i][0]=position[i];
            cars[i][1]=speed[i];

        }
        Arrays.sort(cars,(a,b) -> Integer.compare(b[0],a[0]));
        Stack<Double> st = new Stack <>();
        for(int i =0; i<n;i++){
            int pos = cars[i][0];
            int spd =cars [i][1];
            double timeTaken = (double)(target -pos)/spd;
            if(st.isEmpty() || st.peek() < timeTaken){
                st.push(timeTaken);
            }
        }

        return st.size();
    }
}