class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();
        int n1 = -1;
        int n2 = -1;
        int c1=0, c2 = 0;
        for(int i=0;i<n;i++){
            if(c1 == 0 && nums[i] != n2){
                n1 = nums[i];
                c1++;
            }else if(nums[i] == n1){
                c1++;
            }else if(c2 == 0){
                n2 = nums[i];
                c2++;
            }else if(nums[i] == n2){
                c2++;
            }else{
                c1--;
                c2--;
            }
        }
        c1 = 0;
        c2 = 0;
        for(int i=0;i<n;i++){
            if(nums[i] == n1){
                c1++;
            }else if(nums[i] == n2){
                c2++;
            }
        }
        if(c1 > n/3){
            ans.add(n1);
        }
        if(c2 > n/3){
            ans.add(n2);
        }
        return ans;
    }
}