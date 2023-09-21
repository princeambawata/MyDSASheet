class StockSpanner {

    class Pair{
        int val;
        int in;

        Pair(int x, int y){
            this.val = x;
            this.in = y;
        }
    }

    Stack<Pair> s;
    int currI;

    public StockSpanner() {
        s = new Stack<>();
        currI = 0;
    }
    
    public int next(int price) {
        while(!s.isEmpty() && s.peek().val <= price){
            s.pop();
        }
        if(s.isEmpty()){
            s.push(new Pair(price, currI));
            currI++;
            return currI;
        }else{
            int ans = currI-s.peek().in;
            s.push(new Pair(price, currI));
            currI++;
            return ans;
        }
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */