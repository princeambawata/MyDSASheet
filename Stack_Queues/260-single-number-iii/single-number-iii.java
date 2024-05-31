class Solution {
    public int[] singleNumber(int[] nums) {
        Set<Integer> s = new HashSet<>();
        int n = nums.length;
        for(int i=0;i<n;i++){
            if(!s.contains(nums[i])){
                s.add(nums[i]);
            }else{
                s.remove(nums[i]);
            }
        }
        int[] ans = new int[2];
        int k=0;
        for(Integer i : s){
            ans[k++] = i;
        }
        return ans;
    }
}