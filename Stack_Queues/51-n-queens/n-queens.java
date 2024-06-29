class Solution {

    public boolean isSafe(int[][] dp, int i, int j, int n){
        for(int k=i;k>=0;k--){
            if(dp[k][j] == 1) return false;
        }
        int k = i, l = j;
        while(k>=0 && l>=0){
            if(dp[k][l] == 1) return false;
            k--;
            l--;
        }
        k = i;
        l = j;
        while(k>=0 && l<n){
            if(dp[k][l] == 1) return false;
            k--;
            l++;
        }
        return true;
    }

    public void solve(int[][] dp, List<List<String>> ans, int index, int n){
        if(index == n){
            List<String> ls = new ArrayList<>();
            for(int i=0;i<n;i++){
                String s = new String();
                for(int j=0;j<n;j++){
                    if(dp[i][j] == 0){
                        s = s.concat(".");
                    }else if(dp[i][j] == 1){
                        s = s.concat("Q");
                    }
                }
                ls.add(s);
            }
            ans.add(ls);
            return;
        }
        for(int j=0;j<n;j++){
            if(isSafe(dp, index, j, n)){
                dp[index][j] = 1;
                solve(dp, ans, index+1, n);
                dp[index][j] = 0;
            }
        }
        return;
    }

    public List<List<String>> solveNQueens(int n) {
        int[][] board = new int[n][n];
        List<List<String>> ans = new ArrayList<>();
        solve(board, ans, 0, n);
        return ans;
    }
}