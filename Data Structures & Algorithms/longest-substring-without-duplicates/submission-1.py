class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        L = 0
        max_length = 0
        char_set = set()

        for R in range(len(s)):
            while s[R] in char_set:
                char_set.remove(s[L])
                L += 1 
            char_set.add(s[R])
            max_length = max(R-L+1,max_length)
        return max_length

