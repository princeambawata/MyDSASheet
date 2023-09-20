class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> m = new HashMap<>();
        Stack<Integer> s = new Stack<>();
        int n = nums2.length;
        for(int i=n-1;i>=0;i--){
          while(!s.isEmpty() && nums2[i] >= s.peek()){
            s.pop();
          }
          if(s.isEmpty()){
            m.put(nums2[i], -1);
          }else{
            m.put(nums2[i], s.peek());
          }
          s.push(nums2[i]);
        }
        for(int i=0;i<nums1.length;i++){
          nums1[i] = m.get(nums1[i]);
        }
        return nums1;
    }
}