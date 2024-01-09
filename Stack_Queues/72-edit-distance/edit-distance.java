class Solution {

    public int solve(String word1, String word2, int n, int m, int[][] dp){
        if(n<0) return m+1;
        else if(m<0) return n+1;
        else if(dp[n][m] != -1) return dp[n][m];
        if(word1.charAt(n) == word2.charAt(m)){
            return dp[n][m] = solve(word1, word2, n-1, m-1, dp);
        }else{
            return dp[n][m] = Math.min(solve(word1, word2, n, m-1, dp), Math.min(solve(word1, word2, n-1, m, dp), solve(word1, word2, n-1, m-1, dp))) + 1;
        }
    }

    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        int[][] dp = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dp[i][j] = -1;
            }
        }

        return solve(word1, word2, n-1, m-1, dp);
    }
}