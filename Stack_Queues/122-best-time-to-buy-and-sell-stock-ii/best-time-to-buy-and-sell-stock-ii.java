class Solution {
    public int maxProfit(int[] prices) {
        int ans = 0;
        int buyI = 0;
        int n = prices.length;
        for(int i=1;i<n;i++){
            if(prices[i] > prices[buyI]){
                ans += prices[i]-prices[buyI];
            }
            buyI = i;
        }
        return ans;
    }
}