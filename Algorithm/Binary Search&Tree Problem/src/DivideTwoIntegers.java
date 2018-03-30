class Solution {
    // dividend: 被除数, divisor: 除数
    public int divide(int dividend, int divisor) {
        //Reduce the problem to positive long integer to make it easier
        //Use long to avoid integer overfollow cases.
        if(divisor == 0) return Integer.MAX_VALUE;
        int sign = 1;
        if((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) {
            sign = -1;
        }
        long ldividend = Math.abs((long) dividend);
        long ldivisor = Math.abs((long) divisor);
        if((ldivisor > ldividend) || divisor == 0) return 0;
        long lans = help(ldividend, ldivisor);
        if(lans > Integer.MAX_VALUE) {
            return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        return (int) (sign*lans);
    }
    private long help(long dividend, long divisor) {
        if(divisor > dividend) return 0;
        long currTotal = divisor;
        long multiple = 1;
        while((currTotal + currTotal) < dividend) {
            currTotal += currTotal;
            multiple += multiple;
        }
        return multiple + help(dividend - currTotal, divisor);
    }

}