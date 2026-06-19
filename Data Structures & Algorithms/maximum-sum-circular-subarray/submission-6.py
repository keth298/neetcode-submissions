class Solution:
    def maxSubarraySumCircular(self, nums: List[int]) -> int:
        min_sum, max_sum = nums[0], nums[0]
        cur_min, cur_max = 0, 0
        
        for n in nums:
            cur_min = min(cur_min,0) + n
            min_sum = min(cur_min,min_sum)
            cur_max = max(cur_max,0) + n
            max_sum = max(cur_max,max_sum)
        if max_sum > 0:
            return max((sum(nums) - min_sum),max_sum)
        else:
            return max_sum