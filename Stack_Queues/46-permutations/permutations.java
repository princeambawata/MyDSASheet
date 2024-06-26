class Solution {

    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        return;
    }

    public void solve(int[] nums, List<List<Integer>> ans, int i, int n){
        if(i == n){
            List<Integer> temp = new ArrayList<>();
            for(int j : nums){
                temp.add(j);
            }
            ans.add(temp);
            return;
        }
        for(int j=i;j<n;j++){
            swap(nums, i, j);
            solve(nums, ans, i+1, n);
            swap(nums, j, i);
        }
        return;
    }

    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        solve(nums, ans, 0, n);
        return ans; 
    }
}