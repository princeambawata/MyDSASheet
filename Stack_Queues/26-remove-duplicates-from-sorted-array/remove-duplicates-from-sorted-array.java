class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        int j = 1;
        int n = nums.length;
        if(n == 1) return 1;
        while(j<n){
            if(nums[i] == nums[j]){
                while(j<n){
                    if(nums[j] != nums[i]){
                        nums[++i] = nums[j];
                        break;
                    }
                    j++;
                }
            }else{
                i++;
                j++;
            }
        }
        return i+1;
    }
}