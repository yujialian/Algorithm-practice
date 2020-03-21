//Not inplace
class Solution {
    public void moveZeroes(int[] nums) {
        if(nums == null || nums.length <= 1) {
            return;
        }
        int end = nums.length - 1;
        int start = 0;
        while(nums[end] == 0) {
            end--;
            if(end < 0) {
                return;
            }
        }
        while(start < end) {
            if(nums[start] == 0) {
                nums[start] = nums[end];
                nums[end--] = 0;
            }
            start++;
        }
    }
}
//inplace

class Solution {
    public void moveZeroes(int[] nums) {
        int lastNoneZero = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                nums[lastNoneZero++] = nums[i];
            }
        }
        while(lastNoneZero < nums.length) {
            nums[lastNoneZero++] = 0;
        }
    }
}
