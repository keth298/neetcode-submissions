class Solution:
    def minSubArrayLen(self, target: int, nums: List[int]) -> int:
        L = 0
        cur_sum = 0
        length = len(nums) + 1

        for R in range(len(nums)):
            cur_sum += nums[R]
            while cur_sum >= target:
                length = min(length, R - L + 1)
                cur_sum -= nums[L]
                L += 1
        if length == len(nums) + 1:
            return 0
        else:
            return length