class Solution {
    public int mySqrt(int x) {
        if(x <= 1) return x;
        int l = 1, r = x / 2;
        while(true) {
            int mid = l + (r - l) / 2;
            if(mid > x/mid) {
                r= mid - 1;
            } else {
                if((mid+1) > x/(mid+1)) {
                    return mid;
                }
                l = mid + 1;
            }
        }
    }
}



//class Solution {
    public int mySqrt(int x) {
        if(x == 0 || x == 1) return x;
        int l = 1, r = x / 2, ans = 0;
        while(l <= r) {
            int mid = l + (r - l) / 2;
            int temp = x / mid;
            if(temp == mid) return temp;
            else if(temp > mid) {
                ans = mid;
                l = mid + 1;
            } else {
                r= mid - 1;
            }
        }
        return ans;
    }
}
