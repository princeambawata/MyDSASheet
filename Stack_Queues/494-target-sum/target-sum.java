class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int tsum = 0;
        int n = nums.length; 
        for(int i=0;i<n;i++){
            tsum += nums[i];
        }
        if((tsum+target)%2!=0  || tsum<Math.abs(target)) 
            return 0;
        int sum = (tsum+target)/2;
        int[][] dp = new int[n+1][sum+1];
        for(int i=0;i<=sum;i++){
            dp[0][i] = 0;
        }
        for(int i=0;i<=n;i++){
            dp[i][0] = 1;
        }
        for(int i=1;i<=n;i++){
            for(int j=0;j<=sum;j++){
                int notTake = dp[i-1][j];
                int take = 0;
                if(j-nums[i-1] >= 0){
                    take = dp[i-1][j-nums[i-1]];
                }
                dp[i][j] = take+notTake;
            }
        }
        return dp[n][sum];
    }
}