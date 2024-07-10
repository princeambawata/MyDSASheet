class Solution {
    public int minOperations(String[] logs) {
        Stack<String> s = new Stack<>();
        int n = logs.length;
        for(int i=0;i<n;i++){
            String x = logs[i];
            if(x.equalsIgnoreCase("../")){
                if(s.size() > 0) s.pop();
            }else if(x.equalsIgnoreCase("./")){
                // do nothing
            }else{
                s.push(x);
            }
        }
        return s.size();
    }
}