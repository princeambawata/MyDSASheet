class Solution {

    public int solve(int[] prices, int i, int n, int[][] dp, int tran, int k){
        if(i == n || tran == 2*k) return 0;
        if(dp[i][tran] != -1) return dp[i][tran];
        int ans = 0;
        if(tran%2==0){
            ans = Math.max(-prices[i] + solve(prices, i+1, n, dp, tran+1, k), solve(prices, i+1, n, dp, tran, k));
        }else{
            ans = Math.max(prices[i] + solve(prices, i+1, n, dp, tran+1, k), solve(prices, i+1, n, dp, tran, k));
        }
        dp[i][tran] = ans;
        return ans;
    }   

    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int tran = 2*k;
        int dp[][] = new int[n][tran];
        for(int i=0;i<n;i++){
            for(int j=0;j<tran;j++){
                dp[i][j] = -1;
            }
        }
        return solve(prices, 0, n, dp, 0, k);
    }
}