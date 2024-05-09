import java.util.*;

class Solution {
    public int longestConsecutive(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int n = nums.length;
        for(int i=0;i<n;i++){
            pq.add(nums[i]);
        }
        int maxLen = 0;
        int currLen = 0;
        int prev = -2;
        while(!pq.isEmpty()){
            int top = pq.poll();
            if(prev == top) continue;
            if(prev+1 == top){
                currLen++;
            }else{
                currLen = 1;
            }
            prev = top;
            if(currLen > maxLen){
                maxLen = currLen;
            }
        }
        return maxLen;
    }
}