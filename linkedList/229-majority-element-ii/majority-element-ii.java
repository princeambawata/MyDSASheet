class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();
        if(n == 1){
            ans.add(nums[0]);
            return ans;
        }
        int count1 = 0, count2 = 0, val1 = -999999, val2 = -999999; 
        for(int i=0;i<n;i++){
            //System.out.println("i : "+nums[i]);
            if(val1 == nums[i]){
                count1++;
            }else if(val2 == nums[i]){
                count2++;
            }else if(count1 == 0){
                val1 = nums[i];
                count1 = 1;
            }else if(count2 == 0){
                val2 = nums[i];
                count2 = 1;
            }else{
                count1--;
                count2--;
            }
        }
       // System.out.println("val1 : "+val1);
        count1 = 0;
        count2 = 0;
        for(int i=0;i<n;i++){
            if(nums[i] == val1) count1++;
            else if(nums[i] == val2) count2++;
        }

        if(count1 > n/3) ans.add(val1);
        if(count2 > n/3) ans.add(val2);
        return ans;
    }
}