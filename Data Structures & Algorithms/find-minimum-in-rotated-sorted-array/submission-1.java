class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length;
        while(l < r){
            int m = (r + l) / 2;
            if(nums[m] < nums[0]){
                r = m;
            } else {
                l = m + 1;
            }
        }
        return nums[r % nums.length];
    }
}
