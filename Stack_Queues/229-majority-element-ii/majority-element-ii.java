class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int n = nums.length;
        int val1 = 0, val2 = 0, count1 = 0, count2 = 0;
        for(int i=0;i<n;i++){
            if(val1 == nums[i]){
                count1++;
            }else if(val2 == nums[i]){
                count2++;
            }else if(count1 == 0){
                val1=nums[i];
                count1++;
            }else if(count2 == 0){
                val2 = nums[i];
                count2++;
            }else{
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for(int i=0;i<n;i++){
            if(val1 == nums[i]){
                count1++;
            }else if(val2 == nums[i]) count2++;
        }
        if(count1 > n/3) ans.add(val1);
        if(count2 > n/3) ans.add(val2);
        return ans;
    }
}