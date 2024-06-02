class Solution {
    public String compressedString(String word) {
        Map<Character, Integer> m = new LinkedHashMap<>();
        int n = word.length();
        StringBuilder s = new StringBuilder();
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