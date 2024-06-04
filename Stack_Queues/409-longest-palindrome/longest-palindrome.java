class Solution {
    public int longestPalindrome(String s) {
        Set<Character> set = new HashSet<>();
        int n = s.length();
        int ans = 0;
        for(int i=0;i<n;i++){
            char c = s.charAt(i); 
            if(set.contains(c)){
                set.remove(c);
                ans += 2;
            }else{
                set.add(c);
            }
        }
        if(!set.isEmpty()){
            ans += 1;
        }
        return ans;
    }
}