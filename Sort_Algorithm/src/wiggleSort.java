class Solution {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        for(int i = 1; i < nums.length - 1; i += 2) {
            swap(nums, i, i + 1);
        }
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

class Solution {
    public void wiggleSort(int[] nums) {
        boolean less = true;
        for(int i = 0; i < nums.length - 1; i++) {
            if(less) {
                if(nums[i] > nums[i+1]) {
                    swap(nums, i, i+1);
                }
            } else {
                if(nums[i] < nums[i+1]) {
                    swap(nums, i, i+1);
                }
            }
            less = !less;
        }
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}