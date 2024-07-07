class Solution {

    public boolean isValidWeightCapacity(int[] weights, int mid, int days, int n){
        int i=0, currW = 0;
        int count = 1;
        while(i<n){
            currW += weights[i];
            if(currW > mid){
                count++;
                currW = weights[i];
            }
            if(currW > mid) return false;
            i++;
        }
        if(count <= days) return true;
        else return false;
    }

    public int shipWithinDays(int[] weights, int days) {
        int sum = 0;
        int n = weights.length;
        for(int i=0;i<n;i++){
            sum += weights[i];
        }
        int low = 0, high = sum;
        int ans = sum;
        while(low <= high){
            int mid = (low + high) >> 1;
            if(isValidWeightCapacity(weights, mid, days, n)){
                ans = Math.min(ans, mid);
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return ans;
    }
}