class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        int n = nums.length;
        Arrays.sort(nums);
        for(int i=0;i<n-2;i++){
            int l = i+1;
            int r = n-1;
            while(l<r){
                int s = nums[i] + nums[l] + nums[r];
                if(s == 0){
                    List<Integer> ans2 = new ArrayList<>();
                    ans2.add(nums[i]);
                    ans2.add(nums[l]);
                    ans2.add(nums[r]);
                    set.add(ans2);
                    l++;
                    r--;
                }else if(s > 0){
                    r--;
                }else l++;
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        for(List<Integer> list : set){
            ans.add(list);
        }
        return ans;
    }
}