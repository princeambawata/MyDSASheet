class Solution {

    public int solve(int[] nums, int n, int[] dp){
        if(n == 0) return nums[0];
        else if(n == 1) return Math.max(nums[0], nums[1]);
        if(dp[n] != -1) return dp[n];
        return dp[n] = Math.max(solve(nums, n-1, dp), solve(nums, n-2, dp)+nums[n]);
    }

    public int rob(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n];
        for(int i=0;i<n;i++){
            dp[i] = -1;
        }
        return solve(nums, n-1, dp);
    }
}