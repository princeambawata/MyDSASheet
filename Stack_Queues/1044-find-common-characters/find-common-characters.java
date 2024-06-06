class Solution {
    public List<String> commonChars(String[] words) {
        Map<Character, Integer> m = new ConcurrentHashMap<>();
        int n = words.length;
        String st = words[0];
        for(int j=0;j<st.length();j++){
            char c = st.charAt(j);
            if(!m.containsKey(c)){
                m.put(c,1);
            }else{
                m.put(c, m.get(c)+1);
            }
        }
        for(int i=1;i<n;i++){
            Map<Character, Integer> sm = new HashMap<>(); 
            String str = words[i];
            int k = str.length();
            for(int j=0;j<k;j++){
                char c = str.charAt(j);
                if(sm.containsKey(c)){
                    sm.put(c, sm.get(c)+1);
                }else{
                    sm.put(c,1);
                }
            }
            for(char c : sm.keySet()){
                int val = sm.get(c);
                if(m.containsKey(c)){
                    m.put(c, Math.min(m.get(c), val));
                }
            }
            for(char c : m.keySet()){
                if(!sm.containsKey(c)){
                    m.remove(c);
                }
            }
        }
        List<String> ans = new ArrayList<>();
        for(char c : m.keySet()){
            int val = m.get(c);
            for(int i=0;i<val;i++){
                StringBuilder s = new StringBuilder();
                s.append(c);
                ans.add(s.toString());
            }
        }
        return ans;
    }
}