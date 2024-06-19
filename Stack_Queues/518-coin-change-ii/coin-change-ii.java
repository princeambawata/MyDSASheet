class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int dp[][] = new int[n][amount+1];
        for(int i=0;i<=amount;i++){
            if(i%coins[0] == 0) {
                dp[0][i] = 1;
            }
        }
        for(int i=1;i<n;i++){
            for(int j=0;j<=amount;j++){
                int notTake = dp[i-1][j];
                int take = 0;
                if(j-coins[i] >= 0){
                    take = Math.max(dp[i-1][j-coins[i]], dp[i][j-coins[i]]);
                }
                dp[i][j] = take + notTake;
            }
        }
        return dp[n-1][amount];
    }
}