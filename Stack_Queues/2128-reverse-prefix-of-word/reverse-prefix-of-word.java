
class Solution {
    public String reversePrefix(String word, char ch) {
        int n = word.indexOf(ch);
        if(n == -1) return word;
        StringBuilder s = new StringBuilder();
        s.append(word.substring(0,n+1));
        s.reverse();
        s.append(word.substring(n+1, word.length()));
        return s.toString();
    }
}