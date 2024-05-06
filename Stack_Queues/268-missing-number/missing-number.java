class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int ans = nums[0];
        for(int i=1;i<n;i++){
            ans = ans^nums[i];
        }
        for(int i=0;i<=n;i++){
            ans = ans^i;
        }
        return ans;
    }
}