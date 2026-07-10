class Solution {
    public boolean hasDuplicate(int[] nums) {
        int n = nums.length;
        if (n < 2) return false;

        int capacity = Integer.highestOneBit(Math.max(16, n)) << 2;
        int[] table = new int[capacity];
        boolean[] used = new boolean[capacity];
        int mask = capacity - 1;

        for (int num : nums) {
            int idx = hash(num) & mask;
            while (used[idx]) {
                if (table[idx] == num) return true;
                idx = (idx + 1) & mask;
            }
            table[idx] = num;
            used[idx] = true;
        }
        return false;
    }

    private int hash(int x) {
        x ^= (x >>> 16);
        x *= 0x85ebca6b;
        x ^= (x >>> 13);
        return x;
    }
}