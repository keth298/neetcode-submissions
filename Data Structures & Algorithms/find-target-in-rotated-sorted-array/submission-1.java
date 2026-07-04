class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while(l <= r){
            int m = (r + l) / 2;
            if (nums[m] == target) return m;
            int leftDiff = nums[m] - nums[l];
            if((leftDiff >= 0 && target >= nums[l] && target <= nums[m]) || (leftDiff < 0 && (target >= nums[l] || target <= nums[m])) ){
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return -1;
    }
}
