class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int m = 2*(triangle.get(n-1)).size() - 1 ;
        int dp[][] = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        dp[0][m/2] = (triangle.get(0)).get(0);
        for(int i=1;i<n;i++){
            List<Integer> list = triangle.get(i);
            int s = list.size();
            for(int j=(m/2)-i, k=0;k<s;k++){
                int val = list.get(k);
                int ulv = Integer.MAX_VALUE, urv = Integer.MAX_VALUE;
                if(j-1 >=0){
                    ulv = dp[i-1][j-1];
                }
                if(j+1 < m){
                    urv = dp[i-1][j+1];
                }
                dp[i][j] = Math.min(ulv, urv) + val;
                j += 2;
            }
        }
        int ans = Integer.MAX_VALUE;
        for(int i=0;i<m;){
            ans = Math.min(ans, dp[n-1][i]);
            i += 2;
        }
        return ans;
    }
}