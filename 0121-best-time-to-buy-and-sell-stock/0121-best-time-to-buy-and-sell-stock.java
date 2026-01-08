class Solution {
    public int maxProfit(int[] prices) {
        // int n=prices.length;
        // int min=prices[0];
        // int profit=0;
        // for(int i=1;i<n;i++)
        // {
        //     int cost=prices[i]-min;
        //     profit=Math.max(cost,profit);
        //     min=Math.min(min,prices[i]);
        // }
        // return profit;

        // second logic whhich is have time limit exceed !!!
        // int maxprofit=0;
        
        // for(int i =0;i<prices.length;i++){
        //     for(int j=i+1;j<prices.length;j++){
        //         int profit=prices[j]-prices[i];
        //         maxprofit=Math.max(profit,maxprofit);
        //     }
        // }
        // return maxprofit;

        // third approarch 
        int minbuy=Integer.MAX_VALUE;
        int maxprofit=0;
        for(int i=0; i<prices.length;i++){
            minbuy=Math.min(prices[i],minbuy);
            maxprofit=Math.max(maxprofit,prices[i]-minbuy);
        }
        return maxprofit;
    }
}