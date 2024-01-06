class Solution {

    public int solve(int[][] grid, int m, int n, int[][] dp){
        if(m<0 || n<0) return Integer.MAX_VALUE;
        if(m ==0 && n ==0) return grid[0][0];
        else if(dp[m][n] != -1) return dp[m][n];
        return dp[m][n] = Math.min(solve(grid, m-1, n, dp), solve(grid, m, n-1, dp)) + grid[m][n];
    }

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n  = grid[0].length;
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dp[i][j] = -1;
            }
        }
        return solve(grid, m-1, n-1, dp);
    }
}