class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int ans = 0;
        int maximum = Integer.MIN_VALUE;
        boolean allNeg = true;
        int currSum = 0;
        for(int i=0;i<n;i++){
            currSum += nums[i];
            ans = Math.max(ans,currSum);
            if(currSum < 0){
                currSum = 0;
                maximum = Math.max(maximum, nums[i]);
            }else{
                allNeg = false;
            }
            
        }
        return allNeg == true ? maximum : ans;
    }
}