class Solution {

    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        return;
    }

    public void sortColors(int[] nums) {
        int n = nums.length;
        int l = 0, m = 0, r = n-1;
        while(m<=r){
            if(nums[m] == 0){
                swap(nums, m,l);
                l++;
                m++;
            }else if(nums[m] == 2){
                swap(nums, m, r);
                r--;
            }else{
                m++;
            }
        }
        return;
    }
}