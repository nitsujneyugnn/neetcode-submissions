class Solution {
    public int maxProfit(int[] prices) {
        int buy = 0;
        int maxProfit = 0;
        for (int sell = 1; sell < prices.length; sell++) {
            int profit = prices[sell] - prices[buy];
            if (profit > maxProfit) {
                maxProfit = profit;
            }
            if (prices[sell] < prices[buy]) {
                buy = sell;
            }
        }
        return maxProfit;
    }
}
