class Solution {
    public int maxProfit(int[] prices) {
        int min=prices[0];
        int ans=0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]>min){
                int diff=prices[i]-min;
                ans=Math.max(ans,diff);
            } else{
                min=prices[i];
            }
        }
        return ans;
    }
}