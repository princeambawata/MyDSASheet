class Solution {

    public int solve(int[][] arr, int m, int n, int[][] dp){
        if(m<0 || n<0) return 0;
        else if(arr[m][n] == 1) return 0;
        else if(m == 0 && n == 0) return 1;
        else if(dp[m][n] != -1) return dp[m][n];
        return dp[m][n] = solve(arr, m-1, n, dp) + solve(arr, m, n-1, dp);
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if(obstacleGrid[m-1][n-1] == 1 || obstacleGrid[0][0] == 1) return 0;
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dp[i][j] = -1;
            }
        }
        return solve(obstacleGrid, m-1, n-1, dp);
    }
}