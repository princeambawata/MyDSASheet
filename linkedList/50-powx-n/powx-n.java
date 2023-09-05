class Solution {
    public double solve(double x, int n) {
        if(n == 0) return 1.0d;
        else if(n == 1) return x;
        else if(x == 0) return 0.0d;
        double ans = solve(x, n/2);
        if(n%2 == 0){
            return ans*ans;
        }else return x*ans*ans;
    }

    public double myPow(double x, int n) {
        double ans = solve(x,n);
        if(n < 0) ans = 1/ans;
        return ans;
    }
}