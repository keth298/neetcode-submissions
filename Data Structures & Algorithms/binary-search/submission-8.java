class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length;
        int med = (r - l) /2;
        while(l < r){
            if (nums[med] == target) {
                return med;
            } else if (nums[med] < target){
                l = med + 1;
                med = (r + l) /2 ;
            } else {
                r = med;
                med = (r + l) /2;
            }
        }
        if(med < nums.length && nums[med] == target) return med;
        else return -1;
    }
}
