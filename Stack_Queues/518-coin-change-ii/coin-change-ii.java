class Solution {

    public int solve(int coins[], int n, int amount, int[][] dp){
        if(n == 0) return (amount%coins[0]) == 0 ? 1 : 0;
        else if(amount == 0) return 1; 
        else if(dp[n][amount] != -1) return dp[n][amount];
        int notTake = solve(coins, n-1, amount, dp);
        int take = 0;
        if(amount-coins[n] >= 0){
            take = solve(coins, n, amount-coins[n], dp);
        }
        return dp[n][amount] = notTake+take;
    }

    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<=amount;j++){
                dp[i][j] = -1;
            }
        }
        int ans = solve(coins, n-1, amount, dp);
        return ans;
    }
}