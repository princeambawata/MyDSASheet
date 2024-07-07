class Solution {

    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        return;
    }

    public void heapify(int[] nums, int i, int n){
        int li = 2*i+1;
        int ri = 2*i+2;
        int largest = i;
        if(li < n && nums[largest] < nums[li]){
            largest = li;
        }
        if(ri < n && nums[ri] > nums[largest]){
            largest = ri;
        }
        if(largest != i){
            swap(nums, i, largest);
            heapify(nums, largest, n);
        }
        return;
    }

    public void heapSort(int[] nums, int n){
        for(int i=n/2-1;i>=0;i--){
            heapify(nums, i, n);
        }
        for(int i=n-1;i>0;i--){
            swap(nums, i, 0);
            heapify(nums, 0, i);
        }
        return;
    }

    public int[] sortArray(int[] nums) {
        int n = nums.length;
        heapSort(nums, n);
        return nums;
    }
}