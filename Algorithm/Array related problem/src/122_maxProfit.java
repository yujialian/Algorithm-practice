class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for(int i = 1; i < prices.length; i++) {
            if(prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }
        return maxProfit;
    }
}


class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) return 0;
        int totalProfit = 0;
        int peak = prices[0];
        int valley = prices[0];
        for(int i = 0; i < prices.length - 1; i++) {
            while(i < prices.length - 1 && prices[i] >= prices[i+1]) {
                i++;
            }
            valley = prices[i];
            while(i < prices.length - 1 && prices[i] <= prices[i+1]) {
                i++;
            }
            peak = prices[i];
            totalProfit += peak - valley;
        }
        return totalProfit;
    }
}
