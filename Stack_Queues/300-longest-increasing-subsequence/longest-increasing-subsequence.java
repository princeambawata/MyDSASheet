class Solution {

    public int solve(int[] nums, int index, int n, int prevI,int[][] dp){
        if(index == n) return 0;
        if(dp[index][prevI+1] != -1) return dp[index][prevI+1];
        int notTake = solve(nums, index+1, n, prevI, dp);
        int take = 0;
        if(prevI == -1 || nums[index] > nums[prevI]){
            take = solve(nums, index+1, n, index, dp)+1;
        }
        return dp[index][prevI+1] = Math.max(take, notTake);
    }

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int dp[][] = new int[n][n+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<=n;j++){
                dp[i][j] = -1;
            }
        }

        return solve(nums, 0, n, -1, dp);
    }
}