class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] arr = new int[citations.length + 1];
        for(int i = 0; i < n; i++) {
            if(citations[i] >= n) {
                arr[n]++;
            } else {
                arr[citations[i]]++;
            }
        }
        int tot = 0;
        for(int i = n; i >= 0; i--) {
            tot += arr[i];
            if(tot >= i) {
                return i;
            }
        }
        return 0;
    }
}