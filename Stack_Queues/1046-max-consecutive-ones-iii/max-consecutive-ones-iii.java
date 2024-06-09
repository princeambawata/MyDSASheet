class Solution {
    public int longestOnes(int[] nums, int k) {
        int l = 0, r = 0;
        int ans = 0;
        int curr_l = 0;
        int n = nums.length;
        while(r < n){
            if(nums[r] == 0){
                curr_l ++;
            }
            while(curr_l > k){
                if(nums[l] == 0){
                    curr_l--;
                }
                l++;
            }
            ans = Math.max(ans, r-l+1);
            r++;
        }
        return ans;
    }
}