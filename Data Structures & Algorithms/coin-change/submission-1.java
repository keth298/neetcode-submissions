class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount == 0) return 0;
        
        int[] cache = new int[amount + 1];
        Arrays.fill(cache, amount + 1);
        for(int i = 0; i < coins.length; i++){
            if (coins[i] > amount) continue;
            cache[coins[i]] = 1;
        }
        for(int i = 1; i < amount + 1; i ++){
            if(cache[i] == 1) continue;
            int change = amount + 1;
            for(int c = 0; c < coins.length; c++){
                change = i - coins[c] >= 0 ? Math.min(1 + cache[i - coins[c]], change): change;
            }
            cache[i] = change;
        }
        return cache[amount] < amount + 1? cache[amount]: -1;
    }
}
