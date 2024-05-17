class Solution {
    public double myPow(double x, int n) {
        if(n<0){
            return solve(1/x, -1*n);
        }else{
            return solve(x, n);
        }
    }

    public double solve(double x, int n){
        if(n==0) return 1.0;
        double ans = solve(x,n/2);
        if(n%2 == 0){
            return ans*ans;
        }else{
            return x*ans*ans;
        }
    }
}