class Solution {
    public int findDuplicate(int[] nums) {
        while(nums[nums[0]] != 0){
            int index = nums[0];
            int temp = nums[index];
            nums[index] = 0;
            nums[0] = temp;
        }
        return nums[0];
    }
}
