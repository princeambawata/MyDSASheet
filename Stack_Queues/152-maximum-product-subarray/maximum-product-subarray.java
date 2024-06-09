class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int currMax = 1;
        int currMin = 1;
        int ans = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(nums[i] > 0){
                currMax = Math.max(nums[i], currMax*nums[i]);
                currMin = Math.min(nums[i], currMin*nums[i]);
            }else{
                int temp = currMax;
                currMax = Math.max(nums[i], currMin*nums[i]);
                currMin = Math.min(nums[i], temp*nums[i]);
            }
            ans = Math.max(ans, currMax);
        }
        return ans;
    }
}