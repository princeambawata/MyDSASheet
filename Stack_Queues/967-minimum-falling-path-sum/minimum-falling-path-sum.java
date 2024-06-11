class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int len = matrix.length;
        Integer[][] dp_array = new Integer[len][len];

        dp_array[0][0] = matrix[0][0];
        for(int i=0;i<len;i++){
            dp_array[0][i] = matrix[0][i];
        }

        for(int i = 1 ; i < len ; i++){
            for(int j = 0 ; j < len ; j++){

                if(j == 0){
                    dp_array[i][j] = matrix[i][j] + Math.min(dp_array[i - 1][j], dp_array[i - 1][j+1]); 
                }else if(j == len-1){
                    dp_array[i][j] = matrix[i][j] + Math.min(dp_array[i - 1][j - 1], dp_array[i - 1][j]); 
                }else {
                    dp_array[i][j] = matrix[i][j] + Math.min(dp_array[i - 1][j], Math.min(dp_array[i - 1][j - 1], dp_array[i - 1][j + 1])); 
                }
            }
        }

        int minPath = Integer.MAX_VALUE;
        for(int i = 0 ; i < len ; i++)
            minPath = Math.min(minPath, dp_array[len - 1][i]);

        return minPath;
    }
}