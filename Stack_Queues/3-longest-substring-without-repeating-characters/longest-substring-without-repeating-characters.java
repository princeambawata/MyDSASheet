class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = s.length();
        Map<Character, Integer> m = new HashMap<>();
        int ans = 0, left = 0, i=0;
        for(;i<l;i++){
            char c = s.charAt(i);
            if(!m.containsKey(c)){
                ans = Math.max(ans, i-left+1);
            }else{
                while(m.containsKey(c)){
                    m.remove(s.charAt(left));
                    left++;
                }
            }
            m.put(c, i);
        }
        return ans;
    }
}