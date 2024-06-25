class Solution {

    boolean isPalin(String x){
        int i = 0;
        int j = x.length()-1;
        while(i<j){
            if(x.charAt(i) != x.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public void solve(String s , Set<List<String>> set, List<String> temp, int i, int n){
        if(i >= n){
            if(!temp.isEmpty()){
                List<String> t = new ArrayList<>();
                for(String st : temp){
                    t.add(st);
                }
                set.add(t);
                return;
            }
        }
        for(int k = 1; k+i<=n;k++){
            String x = s.substring(i, i+k);
            if(isPalin(x)){
                temp.add(x);
                solve(s, set, temp, i+k, n);
                temp.remove(temp.size()-1);
            }
        }
        return;
    }

    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        Set<List<String>> set = new HashSet<>();
        List<String> temp = new ArrayList<>();
        int n = s.length();
        solve(s, set, temp, 0, n);
        for(List<String> l : set){
            ans.add(l);
        }
        return ans;
    }
}