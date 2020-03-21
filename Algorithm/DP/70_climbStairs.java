class Solution {
    public int climbStairs(int n) {
        int[] memo = new int[n + 1];
        return climb(0, n, memo);
    }
    private int climb(int i, int n, int[] memo) {
        if(i > n) {
            return 0;
        }
        if(i == n) {
            return 1;
        }
        if(memo[i] > 0) {
            return memo[i];
        }
        memo[i] = climb(i + 1, n, memo) + climb(i + 2, n, memo);
        return memo[i];
    }
}


class Solution {
    public int climbStairs(int n) {
        if(n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}



class Solution {
    public int climbStairs(int n) {
        if(n == 1) return n;
        int first = 1;
        int second = 2;
        int index = 3;
        while(index <= n) {
            int third = first + second;
            first = second;
            second = third;
            index++;
        }
        return second;
    }
}
