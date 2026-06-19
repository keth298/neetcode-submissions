class Solution:
    def numOfSubarrays(self, arr: List[int], k: int, threshold: int) -> int:
        cur_sum = sum(arr[:k])
        L = 0
        res = 0
        if (cur_sum/k) >= threshold:
            res += 1

        for R in range(L + k - 1, len(arr)-1):
            cur_sum += arr[R+1]
            cur_sum -= arr[L]
            if (cur_sum/k) >= threshold:
                res += 1
            L += 1
        return res
            