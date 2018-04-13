class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) {
            return 0;
        }
        int maxPro = 0;
        //iterate from left
        int[] left = new int[prices.length];
        int min = prices[0];
        for(int i = 1; i < prices.length; i++) {
            left[i] = Math.max(left[i - 1], prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        //iterate from right
        int[] right = new int[prices.length];
        int max = prices[prices.length-1];
        for(int i = prices.length - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], max - prices[i]);
            max = Math.max(max, prices[i]);
            maxPro = Math.max(maxPro, left[i] + right[i]);
        }
        return maxPro;
    }
}
