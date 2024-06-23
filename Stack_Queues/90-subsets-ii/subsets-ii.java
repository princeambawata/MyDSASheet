class Solution {

    public void solve(int[] nums, Set<List<Integer>> s, int i, int n, List<Integer> temp){
        if(i == n){
            List<Integer> t = new ArrayList<>();
            for(Integer x : temp){
                t.add(x);
            }
            Collections.sort(t);
            s.add(t);
            return;
        }
        temp.add(nums[i]);
        solve(nums, s, i+1, n, temp);
        temp.remove(temp.size()-1);
        solve(nums, s, i+1, n, temp);
        return;
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<List<Integer>> s = new HashSet<>();
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        List<Integer> temp = new ArrayList<>();
        solve(nums, s, 0, n, temp);
        for(List<Integer> l : s){
            ans.add(l);
        }
        return ans;
    }
}