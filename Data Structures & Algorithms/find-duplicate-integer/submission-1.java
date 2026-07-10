class Solution {
    public int findDuplicate(int[] nums) {
        int fast = 0;
        int slow = 0;
        boolean counter = true;
        while(fast != slow || counter){
            fast = nums[nums[fast]];
            slow = nums[slow];
            counter = false;
        }
        fast = 0;
        while(fast != slow){
            fast = nums[fast];
            slow = nums[slow];
        }
        return slow;
    }
}
