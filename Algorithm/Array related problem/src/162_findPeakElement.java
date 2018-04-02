class Solution {
    public int findPeakElement(int[] nums) {
        if(nums == null || nums.length <= 1) {
            return 0;
        }
        int i = 0;
        for(i = 0; i < nums.length - 1; i++) {
            if(nums[i] > nums[i+1]) {
                return i;
            }
        }
        return i;
    }
}

//Recursion binary search
class Solution {
    public int findPeakElement(int[] nums) {
        return binarySearch(nums, 0, nums.length - 1);
    }
    private int binarySearch(int[] nums, int i, int j) {
        if(i == j) return i;
        int mid = i + (j - i) / 2;
        if(nums[mid] > nums[mid + 1]) {
            return binarySearch(nums, i, mid);
        } else {
            return binarySearch(nums, mid + 1, j);
        }
    }
}
//Interative binary search

class Solution {
    public int findPeakElement(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while(l < r) {
            int mid = l + (r - l) / 2;
            if(nums[mid] > nums[mid + 1]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return nums[l] > nums[r] ? l : r;
    }

}
