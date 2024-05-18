class Solution {

    public int merge(int nums[], int s, int e, int m){
        int ls = m-s+1;
        int lr = e-m;
        int la[] = new int[ls];
        int ra[] = new int[lr];
        for(int i=0, j=s;i<ls;i++, j++){
            la[i] = nums[j];
        }
        for(int i=0, j=m+1;i<lr;i++, j++){
            ra[i] = nums[j];
        }
        int count = 0;
        int i=0, j=0;
        while(i<ls && j < lr){
            if((long)la[i] > 2L * ra[j]){
                count += ls-i;
                j++;
            }else{
                i++;
            }
        }
        

        i=0;
        j=0;
        int k = s;
        while(i<ls && j<lr){
            if(la[i] <= ra[j]){
                nums[k++] = la[i++];
            }else{
                nums[k++] = ra[j++];
            }
        }
        while(i<ls){
            nums[k++] = la[i++];
        }
        while(j<lr){
            nums[k++] = ra[j++];
        }
        return count;
    }

    public int solve(int[] nums, int s, int e){
        if(s>=e) return 0;
        int mid = (s+e)/2;
        return solve(nums, s, mid) + solve(nums, mid+1, e) + merge(nums, s, e, mid);
    }

    public int reversePairs(int[] nums) {
        int n = nums.length;
        return solve(nums, 0, n-1);
    }
}