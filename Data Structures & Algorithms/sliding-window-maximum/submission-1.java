class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        TreeMap<Integer, Integer> tree = new TreeMap<>();
        for(int i = 0; i < k; i++){
            tree.put(nums[i], tree.getOrDefault(nums[i], 0) + 1);
        }

        int[] res = new int[nums.length - k + 1];
        for(int r = k; r < nums.length; r++){
            res[r-k] = tree.lastKey();
            tree.put(nums[r], tree.getOrDefault(nums[r], 0) + 1);
            int count = tree.get(nums[r-k]);
            if (count == 1) tree.remove(nums[r-k]);
            else tree.put(nums[r-k], count - 1);
        }
        res[nums.length - k] = tree.lastKey();

        return res;
    }
}
