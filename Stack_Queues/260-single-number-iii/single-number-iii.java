class Solution {
    public int[] singleNumber(int[] nums) {
        // Set<Integer> s = new HashSet<>();
        // int n = nums.length;
        // for(int i=0;i<n;i++){
        //     if(!s.contains(nums[i])){
        //         s.add(nums[i]);
        //     }else{
        //         s.remove(nums[i]);
        //     }
        // }
        // int[] ans = new int[2];
        // int k=0;
        // for(Integer i : s){
        //     ans[k++] = i;
        // }
        // return ans;

        int n = nums.length;
        int xor = 0;
        for(int i : nums){
            xor ^= i;
        }
        int rmsb = xor & (-1*xor);
        int[] ans = new int[2];
        ans[0] = 0;
        ans[1] = 0;
        for(int num : nums){
            int x = rmsb & num;
            if(x == 0){
                ans[0] ^=  num;
            }else{
                ans[1] ^= num;
            }
        }
        return ans;
    }
}