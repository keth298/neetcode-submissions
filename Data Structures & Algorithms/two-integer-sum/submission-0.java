class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> conjugates = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            conjugates.put(target - nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            if (conjugates.containsKey(nums[i]) && conjugates.get(nums[i]) != i) {
                int j = conjugates.get(nums[i]);
                return new int[]{i, j};
            }
        }
        return new int[0];
    }
}
