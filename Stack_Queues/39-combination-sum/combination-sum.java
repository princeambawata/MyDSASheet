class Solution {

    public void solve(int[] candidates, int i, int n, Set<List<Integer>> s, List<Integer> temp, int cs, int target){
        if(cs > target || i >= n){
            return;
        }else if(cs == target){
            List<Integer> t = new ArrayList<>();
            for(Integer I : temp){
                t.add(I);
            }
            s.add(t);
            return;
        }
        temp.add(candidates[i]);
        solve(candidates, i, n, s, temp, cs+candidates[i], target);
        temp.remove(temp.size()-1);
        solve(candidates, i+1, n, s, temp, cs, target);
        return; 
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int n = candidates.length;
        List<List<Integer>> ans = new ArrayList<>();
        Set<List<Integer>> s = new HashSet<>();
        List<Integer> temp = new ArrayList<>();
        solve(candidates, 0, n, s, temp, 0, target);
        for(List<Integer> l : s){
            ans.add(l);
        } 
        return ans;
    }
}