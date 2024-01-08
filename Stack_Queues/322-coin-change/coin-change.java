class Solution {

    public int solve(int coins[], int n, int amount, int[][] dp){
        if(n == 0) return (amount%coins[0]) == 0 ? amount/coins[0] : Integer.MAX_VALUE;
        else if(amount == 0) return 0; 
        else if(dp[n][amount] != -1) return dp[n][amount];
        int notTake = solve(coins, n-1, amount, dp);
        int take = Integer.MAX_VALUE;
        if(amount-coins[n] >= 0){
            int f = solve(coins, n-1, amount-coins[n], dp);
            int s = solve(coins, n, amount-coins[n], dp);
            if(f != Integer.MAX_VALUE || s != Integer.MAX_VALUE){
               take = Math.min(solve(coins, n-1, amount-coins[n], dp), solve(coins, n, amount-coins[n], dp)) + 1;
            }
        }
        return dp[n][amount] = Math.min(notTake, take);
    }

    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<=amount;j++){
                dp[i][j] = -1;
            }
        }
        int ans = solve(coins, n-1, amount, dp);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}