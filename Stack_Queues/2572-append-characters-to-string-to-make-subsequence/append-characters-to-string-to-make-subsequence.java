class Solution {
    public int appendCharacters(String s, String t) {
        int si = 0;
        int ti = 0;
        int sl = s.length();
        int tl = t.length();
        for(;si < sl && ti < tl;){
            if(s.charAt(si) == t.charAt(ti)){
                ti++;
            }
            si++;
        }
        return tl-ti;
    }
}