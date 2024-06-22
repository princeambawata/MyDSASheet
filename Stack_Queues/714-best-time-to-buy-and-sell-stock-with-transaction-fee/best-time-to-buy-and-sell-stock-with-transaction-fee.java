class Solution {

    public int solve(int[] prices, int i, int n, int[][] dp, int canBuy, int fees){
        if(i == n) return 0;
        if(dp[i][canBuy] != -1) return dp[i][canBuy];
        int ans = 0;
        if(canBuy==1){
            ans = Math.max(-prices[i] + solve(prices, i+1, n, dp, 0, fees), solve(prices, i+1, n, dp, 1, fees));
        }else{
            ans = Math.max(prices[i] - fees + solve(prices, i+1, n, dp, 1, fees), solve(prices, i+1, n, dp, 0, fees));
        }
        dp[i][canBuy] = ans;
        return ans;
    }

    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int dp[][] = new int[n][2];
        for(int i=0;i<n;i++){
            for(int j=0;j<2;j++){
                dp[i][j] = -1;
            }
        }
        return solve(prices, 0, n, dp, 1, fee);
    }
}