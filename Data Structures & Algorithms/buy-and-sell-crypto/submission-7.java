class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }

        int buy = 0;
        int maxProfit = 0;
        for (int sell = 1; sell < prices.length; sell++) {
            if (prices[sell] - prices[buy] > maxProfit) {
                maxProfit = prices[sell] - prices[buy];
            }

            if (prices[sell] < prices[buy]) {
                buy = sell;
            }
        }
        return maxProfit;
    }
}
