class Solution {
    public int scoreOfString(String s) {
        int curr = 1;
        int prev = 0;
        int n = s.length();
        int ans = 0;
        while(curr < n){
            int v2 = s.charAt(curr) - '0';
            int v1 = s.charAt(prev) - '0';
            ans += Math.abs(v1-v2);
            prev = curr;
            curr++;
        }
        return ans;
    }
}