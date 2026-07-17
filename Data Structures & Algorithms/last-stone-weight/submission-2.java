class Solution {
    public int lastStoneWeight(int[] stones) {
        if (stones == null || stones.length == 0) return 0;
        if (stones.length == 1) return stones[0];

        int max = 0;
        for (int s : stones) max = Math.max(max, s);

        int[] freq = new int[max + 1];
        for (int s : stones) freq[s]++;

        int total = stones.length;
        int w = max;

        while (total > 1) {

            while (w > 0 && freq[w] == 0) w--;
            int w1 = w;
            freq[w1]--; total--;

            while (w > 0 && freq[w] == 0) w--;
            int w2 = w;
            freq[w2]--; total--;

            if (w1 != w2) {
                int d = w1 - w2;
                freq[d]++; total++;
                if (d > w) w = d; 
            }
        }

        for (int i = w; i >= 1; i--) if (freq[i] > 0) return i;
        return 0;
    }
}
