class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        if(nums.length == 3) return nums[0] + nums[1] + nums[2];
        int maxSum = nums[0] + nums[1] + nums[2];
        for(int i = 0; i <= nums.length - 3; i++) {
            int l = i + 1, r = nums.length - 1;
            while(l < r) {
                int tmpSum = nums[i] + nums[l] + nums[r];
                if(Math.abs(target - tmpSum) < Math.abs(target - maxSum)) {
                    maxSum = tmpSum;
                }
                if(maxSum == target) return maxSum;
                if(tmpSum > target) {
                    r--;
                } else {
                    l++;
                }
            }
        }
        return maxSum;
    }
}
