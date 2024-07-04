class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        int n = nums.length;
        int i=0;
        for(;i<k;i++){
            q.offer(nums[i]);
        }
        while(i<n){
            if(q.peek() < nums[i]){
                q.poll();
                q.add(nums[i]);
            }
            i++;
        }
        return q.peek();
    }
}