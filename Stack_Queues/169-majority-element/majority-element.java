class Solution {
    public int majorityElement(int[] nums) {
        int count = 1;
        int n = nums.length;
        int val = nums[0];
        for(int i=1;i<n;i++){
            if(val == nums[i]){
                count++;
            }else{
                count--;
            }
            if(count == 0){
                val = nums[i];
                count = 1;
            }
        }
        count = 0;
        for(int i=0;i<n;i++){
            if(nums[i] == val){
                count++;
            }
        }
        if(count>n/2) return val;
        else return -1;
    }
}