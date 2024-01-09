class Solution {

    public int lcs(String text1, String text2){
        // Write your code here.
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n+1][m+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                dp[i][j] = -1;
            }
        }
        //return solve(text1, text2, n-1, m-1, dp);
        for(int i=0;i<=n;i++){
            dp[i][0] = 0;
        }
        for(int j=0;j<=m;j++){
            dp[0][j] = 0;
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }   

    public int minDistance(String word1, String word2) {
        int lcsL = lcs(word1, word2);
        int remove = word1.length()-lcsL;
        int add = word2.length() - lcsL;
        return (remove + add);
    }
}