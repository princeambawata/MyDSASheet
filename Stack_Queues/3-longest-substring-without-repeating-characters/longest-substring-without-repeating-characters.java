class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, left = 0;
        for(int right=0;right<l;right++){
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