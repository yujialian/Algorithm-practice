class Solution {
    public int findKthLargest(int[] nums, int k) {
        quickSort(nums);
        return nums[nums.length - k];
    }
    private int partition(int[] arr, int l, int r) {
        int lst = l;
        int val = arr[l];
        for(int i = l+1; i <= r; i++) {
            if(arr[i] < val) {
                swap(arr, ++lst, i);
            }
        }
        swap(arr, lst, l);
        return lst;
    }
    private void sort(int[] arr, int l, int r) {
        if(l >= r) return;
        int p = partition(arr, l, r);
        sort(arr, l, p-1);
        sort(arr, p+1, r);
    }
    private void quickSort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
