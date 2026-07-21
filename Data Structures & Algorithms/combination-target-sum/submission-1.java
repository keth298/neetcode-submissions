class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new LinkedList<>();
        backTrack(0, 0, nums, target, new LinkedList<>(), res);
        return res;
    }

    public void backTrack(int start, int sum, int[] nums, int target, List<Integer> curr, List<List<Integer>> res){
        if(sum == target){
            res.add(new LinkedList<>(curr));
            return;
        }
        if(sum > target) return;
        for(int i = start; i < nums.length; i++){
            
            curr.add(nums[i]);

            backTrack(i, sum + nums[i], nums, target, curr, res);

            curr.removeLast();
        }
    }
}
