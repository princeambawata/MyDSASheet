class Solution {

    public int solve(String f, String s, int n, int m, int[][] dp){
        if(n<0 || m< 0) return 0;
        if(dp[n][m] != -1) return dp[n][m];
        if(f.charAt(n) == s.charAt(m)){
            return dp[n][m] = solve(f,s,n-1,m-1,dp) + 1;
        }else{
            return dp[n][m] = Math.max(solve(f,s,n-1,m, dp), solve(f,s,n,m-1,dp));
        }
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dp[i][j] = -1;
            }
        }
        return solve(text1, text2, n-1, m-1, dp);
        // for(int i=0;i<=n;i++){
        //     dp[i][0] = 0;
        // }
        // for(int j=0;j<=m;j++){
        //     dp[0][j] = 0;
        // }

        // for(int i=1;i<=n;i++){
        //     for(int j=1;j<=m;j++){
        //         if(text1.charAt(i-1) == text2.charAt(j-1)){
        //             dp[i][j] = dp[i-1][j-1] + 1;
        //         }else{
        //             dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
        //         }
        //     }
        // }
        // return dp[n][m];
    }
}