class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int n = nums.length, sum = 0, left = 0, len = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            sum += nums[i];
            while(sum >= s) {
                len = Math.min(len, i - left + 1);
                sum -= nums[left++];
            }
        }
        return len == Integer.MAX_VALUE ? 0 : len;
    }
}
