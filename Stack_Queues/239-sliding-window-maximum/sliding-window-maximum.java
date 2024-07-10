import java.util.ArrayDeque;
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        int n = nums.length;
        int ans[] = new int[n-k+1];
        int in = 0;
        for(int i=0;i<n;i++){
            if(!q.isEmpty() && i-q.peekFirst()>=k){
                q.pollFirst();
            }
            while(!q.isEmpty() && nums[q.peekLast()]<=nums[i]){
                q.pollLast();
            }
            q.offer(i);
            if(i+1>=k){
                ans[in++] = nums[q.peekFirst()];
            }
        }
        return ans;
    }
}