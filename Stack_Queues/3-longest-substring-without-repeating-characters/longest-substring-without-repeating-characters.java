class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = s.length();
        Map<Character, Integer> m = new HashMap<>();
        int ans = 0, in = 0, i=0;
        for(;i<l;i++){
            char c = s.charAt(i);
            if(m.containsKey(c)){
                int foundIn = m.get(c);
                ans = Math.max(ans, i-in);
                if(in<=foundIn){
                    in = foundIn+1;
                }
            }
            m.put(c,i);
        }
        ans = Math.max(ans, i-in);
        return ans;
    }
}