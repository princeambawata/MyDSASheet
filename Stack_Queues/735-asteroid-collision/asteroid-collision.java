class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int n = asteroids.length;
        Stack<Integer> s = new Stack<>();
        for(int i=0;i<n;i++){
            int x = asteroids[i];
            if(x<0){
                boolean burst = false;
                while(!s.isEmpty() && s.peek() > 0 && x + s.peek() <= 0){
                    if(x + s.peek() == 0){
                        s.pop();
                        burst = true;
                        break;
                    }
                    s.pop();
                }
                if(s.isEmpty() && !burst) s.push(x);
                else if(!s.isEmpty() && s.peek() < 0 && !burst) s.push(x);
            }else {
                s.push(x);
            }
        }
        int[] ans = new int[s.size()];
        for(int i=s.size()-1;i>=0;i--){
            ans[i] = s.pop();
        }
        return ans;
    }
}