class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {

        int [][] dis = new int [26][26];
        for(int i =0; i<26 ;i++){
            Arrays.fill(dis[i] , Integer.MAX_VALUE);
            dis[i][i]=0;
        }

        for(int i =0; i<cost.length ;i++){
            int u = original[i] -'a';
            int v= changed[i] -'a';
            dis[u][v] =Math.min(dis[u][v] ,cost[i]);
        }

        for(int k =0;k<26;k++){
            for(int i =0;i<26;i++){
                if(dis [i][k] ==Integer.MAX_VALUE) continue;

                for(int j =0;j<26; j++){
                    if(dis[k] [j] ==Integer.MAX_VALUE) continue;

                    dis[i][j] =Math.min(dis[i][j] ,dis[i][k] +dis[k][j]);
                }
            }
        }

        long totalCost =0L;
        for(int i =0;i<source.length ();i++){
            int c1 = source.charAt(i) -'a';
            int c2 = target.charAt(i)-'a';

            if(dis[c1][c2] ==Integer.MAX_VALUE){
                return  -1L;

            }

            totalCost +=(long) dis[c1][c2];
        }
        return totalCost;
        
    }
    
}