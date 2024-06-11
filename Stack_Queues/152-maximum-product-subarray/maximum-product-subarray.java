class Solution {
    public int maxProduct(int[] nums) {
        // int max_prod = 1;
        // int min_prod = 1;
        // int ans = Integer.MIN_VALUE;
        // int n = nums.length;
        // for(int i=0;i<n;i++){
        //     if(nums[i] > 0){
        //         max_prod = Math.max(max_prod*nums[i], nums[i]);
        //         min_prod = Math.min(max_prod*nums[i], nums[i]);
        //     }else{
        //         int temp = max_prod;
        //         max_prod = Math.max(min_prod*nums[i], nums[i]);
        //         min_prod = Math.min(temp*nums[i], nums[i]);
        //     }
        //     ans = Math.max(ans, max_prod);
        // }
        // return ans;
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