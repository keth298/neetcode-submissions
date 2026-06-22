class Solution {
    public int maxProfit(int[] prices) {
        int prof = 0;
        int low = 100;

        for(int i = 0; i < prices.length;i++){
            if(prices[i] < low) low = prices[i];
            if(prof < prices[i] - low) prof = prices[i] - low;
        }

        return prof;
    }
}
