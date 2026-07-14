class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) return 0;
        
        int n = prices.length;
        int[] buy = new int[n];
        int[] sell = new int[n];
        
        buy[0] = prices[0];
        sell[0] = 0;
        
        for (int i = 1; i < n; i++) {
            sell[i] = Math.max(sell[i - 1], prices[i] - buy[i - 1]);
            buy[i] = Math.min(buy[i - 1], prices[i] - (i >= 2 ? sell[i - 2] : 0));
        }
        
        return sell[n - 1];
    }
}