
public class Solution {
	public double myPow(double x, int n) {
		if(n < 0) return 1/x * myPow(1/x, -(n+1));
		if(n == 0) return 1;
		if(n == 2) return x*x;
		if(n % 2 == 0) return myPow(myPow(x, n/2), 2);
		return x*myPow(x, n-1);
	}
}

class Solution {
    public double myPow(double x, int n) {
        if(n == 0) return 1;
        double t = myPow(x, n / 2);
        if(n % 2 != 0) return n > 0 ? x*t*t:1/x*t*t;
        return t*t;
    }
}

public class Solution {
    public double myPow(double x, int n) {
        long absN = Math.abs((long) n);
        double ans = 1;
        while(absN > 0) {
            if((absN&1) == 1) {
                ans *= x;
            }
            absN >>= 1;
            x *= x;
        }
        return n > 0 ? ans : 1/ans;
    }
}