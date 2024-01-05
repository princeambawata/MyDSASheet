class Solution {

    public int solve(int[] nums, int n, int[] dp){
        if(n == 0) return nums[0];
        else if(n == 1) return Math.max(nums[0], nums[1]);
        if(dp[n] != -1) return dp[n];
        return dp[n] = Math.max(solve(nums, n-1, dp), solve(nums, n-2, dp)+nums[n]);
    }


    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        else if(n == 2) return Math.max(nums[0], nums[1]);
        int dp[] = new int[n];
        for(int i=0;i<n;i++){
            dp[i] = -1;
        }
        int f = nums[0];
        nums[0] = 0;
        int fa = solve(nums, n-1, dp);
        for(int i=0;i<n;i++){
            dp[i] = -1;
        }
        nums[0] = f;
        int sa = solve(nums, n-2, dp);
        return Math.max(fa, sa);
    }
}