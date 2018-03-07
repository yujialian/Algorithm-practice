class Solution {
    public boolean isPerfectSquare(int num) {
        int low = 1, high = num;
        while(low <= high) {
            long mid = (low + high)/2;
            if(mid * mid == num) {
                return true;
            } else if(mid * mid < num) {
                low = (int) mid + 1;
            }else {
                high = (int) mid - 1;
            }
        }
        return false;
    }
}

//A square number is 1+3+5+7+..., JAVA code
public boolean iPerfectSqure(int num) {
	int idx = 1;
	while(num > 0) {
		num -= idx;
		idx += 2;
	}
	return num == 0;
}