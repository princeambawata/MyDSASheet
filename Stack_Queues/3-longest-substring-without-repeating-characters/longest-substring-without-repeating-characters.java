class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int n = s.length();
        int ans = 0;
        int left = 0, right = 0;
        for(;right < n;right++){
            char c = s.charAt(right);
            if(!set.contains(c)){
                ans = Math.max(ans, right-left+1);
            }else{
                while(set.contains(c)){
                    set.remove(s.charAt(left));
                    left++;
                }
            }
            set.add(c);
        }
        return ans;
    }
}