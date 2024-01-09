class Solution {

    public int lcp(String s, String rs){
        int n = s.length();
        int[][] dp = new int[n+1][n+1];
        for(int i=0;i<=n;i++){
            dp[i][0] = 0;
            dp[0][i] = 0;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(s.charAt(i-1) == rs.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else{
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        return dp[n][n];
    }

    public int minInsertions(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        sb.reverse();
        String rs = sb.toString();
        int lcp1 = lcp(s, rs);
        return s.length()-lcp1;
    }
}