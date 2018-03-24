class Solution {
    //If number of character == n/2+1, odd only
    public String reorganizeString(String S) {
        int n = S.length();
        int[] alpha = new int[26];
        int hf = 0;
        for(int i = 0; i < S.length(); i++) {
            if(++alpha[S.charAt(i) - 'a'] > hf) hf = alpha[S.charAt(i) - 'a'];
        }
        if(hf > (n+1)/2) {
            return "";
        }
        int odd = 0, even = 1;
        char[] ans = new char[n];
        for(int i = 0; i < alpha.length; i++) {
            while(even < n && alpha[i] < n/2 + 1 && alpha[i] > 0) {
                ans[even] = (char)(i + 'a');
                alpha[i]--;
                even += 2;
            }
            while(alpha[i] > 0) {
                ans[odd] = (char)(i + 'a');
                alpha[i]--;
                odd += 2;
            }
        }
        return new String(ans);
    }
}