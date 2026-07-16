class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        else if(nums.length == 2) return Math.max(nums[0],nums[1]);
        int rob1 = 0;
        int rob2 = 0;
        for(int i = 1; i < nums.length; i++){
            int temp = Math.max(nums[i] + rob1, rob2);
            rob1 = rob2;
            rob2 = temp;
        }
        int noHead = Math.max(rob1, rob2);
        rob1 = 0;
        rob2 = 0;
        for(int i = 0; i < nums.length - 1; i++){
            int temp = Math.max(nums[i] + rob1, rob2);
            rob1 = rob2;
            rob2 = temp;
        }
        return Math.max(noHead, Math.max(rob1, rob2));
    }
}
