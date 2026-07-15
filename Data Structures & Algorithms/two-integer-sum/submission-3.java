class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> num = new HashMap<>();
        int[] res = new int[2];
        for(int i = 0; i < nums.length; i++){
            int diff = target - nums[i];
            if(num.containsKey(diff)){
                res[0] = num.get(diff);
                res[1] = i;
            } else {
                num.put(nums[i], i);
            }
        }
        return res;
    }
}
