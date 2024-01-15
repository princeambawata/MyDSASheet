class Solution {
    public int[][] merge(int[][] nums) {
        Arrays.sort(nums, (a,b) -> {
            return Integer.compare(a[0], b[0]);
        });
        int n = nums.length;
        List<int[]> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(list.isEmpty()){
                int[] arr = new int[2];
                arr[0] = nums[i][0];
                arr[1] = nums[i][1];
                list.add(arr);
            }else{
                int[] prev = list.get(list.size()-1);
                if(prev[1] >= nums[i][0]){
                    list.remove(list.size()-1);
                    int[] arr = new int[2];
                    arr[0] = prev[0];
                    arr[1] = Math.max(prev[1],nums[i][1]);
                    list.add(arr);
                }else{
                    int[] arr = new int[2];
                    arr[0] = nums[i][0];
                    arr[1] = nums[i][1];
                    list.add(arr);
                }
            }
        }
        int size = list.size();
        int[][] ans = new int[size][2];
        for(int i=0;i<size;i++){
            int[] arr = list.get(i);
            ans[i][0] = arr[0];
            ans[i][1] = arr[1];
        }
        return ans;
    }
}