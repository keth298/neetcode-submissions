class Solution {
    public int rob(int[] nums) {
        int one = 0;
        int two = 0;
        for(int i = 0; i < nums.length; i++){
            int temp = one;
            one = Math.max(nums[i] + two, one);
            two = temp;
        }
        return one;
    }
}
