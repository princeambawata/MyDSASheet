class Solution {
    public int maximumGain(String s, int x, int y) {
        String high = "";
        String low = "";
        int hp, lp;
        if(x > y){
            high += "ab";
            low += "ba";
            hp = x;
            lp = y;
        }else{
            high += "ba";
            low += "ab";
            hp = y;
            lp = x;
        }
        int ans = 0;
        StringBuilder st = new StringBuilder();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            int l = st.length();
            if(l > 0 && st.charAt(l-1) == high.charAt(0) && c == high.charAt(1)){
                ans += hp;
                st.deleteCharAt(l-1);
            }else{
                st.append(""+c);
            }
        }
        StringBuilder new_st = new StringBuilder();
        for(int i=0;i<st.length();i++){
            char c = st.charAt(i);
            int l = new_st.length();
            if(l > 0 && new_st.charAt(l-1) == low.charAt(0) && c == low.charAt(1)){
                ans += lp;
                new_st.deleteCharAt(l-1);
            }else{
                new_st.append(""+c);
            }
        }
        return ans;
    }
}