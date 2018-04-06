class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] arr = new int[m];
        for(int i = 0; i < arr.length; i++) {
            arr[i] = nums1[i];
        }
        int nums1Index = 0, nums2Index = 0;
        while(nums1Index < arr.length && nums2Index < nums2.length) {
            if(arr[nums1Index] > nums2[nums2Index]) {
                nums1[nums1Index+nums2Index] = nums2[nums2Index];
                nums2Index++;
            } else {
                nums1[nums1Index+nums2Index] = arr[nums1Index];
                nums1Index++;
            }
        }
        while(nums1Index < arr.length) {
            nums1[nums1Index+nums2Index] = arr[nums1Index++];
        }
        while(nums2Index < nums2.length) {
            nums1[nums1Index+nums2Index] = nums2[nums2Index++];
        }
    }
}

///With out space.

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, k = m + n - 1;
        while(j >= 0 && i >= 0) nums1[k--] = (nums1[i] > nums2[j]) ? nums1[i--] : nums2[j--];
        while(j >= 0) nums1[k--] = nums2[j--];
    }
}
