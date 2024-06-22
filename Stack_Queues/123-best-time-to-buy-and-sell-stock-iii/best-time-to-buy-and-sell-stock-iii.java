class Solution {

    public int solve(int[] prices, int i, int n, int[][] dp, int canBuy, int tran){
        if(i == n || tran == 4) return 0;
        if(dp[i][tran] != -1) return dp[i][tran];
        int ans = 0;
        if(canBuy==1){
            ans = Math.max(-prices[i] + solve(prices, i+1, n, dp, 0, tran+1), solve(prices, i+1, n, dp, 1, tran));
        }else{
            ans = Math.max(prices[i] + solve(prices, i+1, n, dp, 1, tran+1), solve(prices, i+1, n, dp, 0, tran));
        }
        dp[i][tran] = ans;
        return ans;
    }
    
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dp[][] = new int[n][4];
        for(int i=0;i<n;i++){
            for(int j=0;j<4;j++){
                dp[i][j] = -1;
            }
        }
        return solve(prices, 0, n, dp, 1, 0);
    }
}