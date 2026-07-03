class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int l = 1;
        int r = piles[piles.length - 1];
        while(l < r){
            int m = (r + l) / 2;
            long hoursPastCurrent = 0;
            for(int i = 0; i < piles.length; i++){
                hoursPastCurrent += (piles[i] + m - 1L) / m;
            }
            if(hoursPastCurrent <= h){
                r = m;
            } else {
                l = m + 1;
            }

        }
        return r;
    }
}
