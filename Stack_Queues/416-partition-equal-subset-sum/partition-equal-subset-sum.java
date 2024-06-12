class Solution {
    public boolean canPartition(int[] arr) {
        int N = arr.length;
        int sum = 0;
        for(int i=0;i<N;i++){
            sum += arr[i];
        }
        if(sum%2 != 0) return false;
        sum = sum/2;
        boolean[][] dp = new boolean[N][sum+1];
        for(int i=0;i<N;i++){
            dp[i][0] = true;
            for(int j=1;j<=sum;j++){
                dp[i][j] = false; 
            }
        }
        if(arr[0] <= sum){
            dp[0][arr[0]] = true;
        }
        for(int i=1;i<N;i++){
            for(int j=1;j<=sum;j++){
                boolean first = dp[i-1][j];
                boolean second = false;
                if(j-arr[i] >= 0){
                    second = dp[i-1][j-arr[i]];
                }
                dp[i][j] = first || second;
            }
        }
        return dp[N-1][sum];
    }
}