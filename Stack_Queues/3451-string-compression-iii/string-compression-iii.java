class Solution {
    public String compressedString(String word) {
        Map<Character, Integer> m = new LinkedHashMap<>();
        int n = word.length();
        // for(int i=0;i<n;i++){
        //     char c = word.charAt(i);
        //     if(m.containsKey(c)){
        //         m.put(c, m.get(c)+1);
        //     }else{
        //         m.put(c, 1);
        //     }
        // }
        StringBuilder s = new StringBuilder();
        // for(Map.Entry<Character, Integer> e : m.entrySet()){
        //     int val = e.getValue();
        //     while(val>0){
        //         if(val > 9){
        //             String st = "" + 9 + e.getKey();
        //             s.append(st);
        //             val = val-9;
        //         }else{
        //             String st = "" + val + e.getKey();
        //             s.append(st);
        //             val = 0;
        //         }
        //     }
        // }
        int count = 1;
        for(int i=1;i<n;i++){
            if(word.charAt(i) == word.charAt(i-1)){
                count++;
            }else{
                while(count>0){
                    if(count > 9){
                        String st = "" + 9 + word.charAt(i-1);
                        s.append(st);
                        count = count-9;
                    }else{
                        String st = "" + count + word.charAt(i-1);
                        s.append(st);
                        count = 0;
                    }
                }
                count = 1;
            }
        }
        while(count>0){
            if(count > 9){
                String st = "" + 9 + word.charAt(n-1);
                s.append(st);
                count = count-9;
            }else{
                String st = "" + count + word.charAt(n-1);
                s.append(st);
                count = 0;
            }
        }
        return s.toString();
    }
}