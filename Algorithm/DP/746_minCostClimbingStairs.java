class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int first = 0, second = 0;
        for(int i = 0; i < cost.length; i++) {
            int third = cost[i] + Math.min(first, second);
            first = second;
            second = third;
        }
        return Math.min(first, second);
    }
}
