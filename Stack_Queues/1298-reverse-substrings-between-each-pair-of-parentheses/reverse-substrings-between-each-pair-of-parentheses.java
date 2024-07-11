class Solution {

    public String reverseParentheses(String s) {
        int n = s.length();
        Stack<Character> st = new Stack<>();
        for(int i=0;i<n;i++){
            char c = s.charAt(i);
            if(c == ')'){
                Queue<Character> q = new LinkedList<>();
                while(st.peek() != '('){
                    q.add(st.pop());
                }
                st.pop();
                while(!q.isEmpty()){
                    st.push(q.poll());
                }
            }else{
                st.push(c);
            }
        }
        StringBuilder ans = new StringBuilder();
        while(!st.isEmpty()){
            ans = ans.append("" + st.pop());
        }
        ans.reverse();
        return ans.toString();
    }
}