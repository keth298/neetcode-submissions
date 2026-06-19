class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> setNums = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            if(!setNums.contains(nums[i])){
                setNums.add(nums[i]);
            } else {
                return true;
            }
        }
        return false;
    }
}