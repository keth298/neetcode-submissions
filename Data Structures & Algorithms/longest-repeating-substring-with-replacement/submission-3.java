class Solution {
    public int characterReplacement(String s, int k) {
        int max_Length = 0;
        for (char target = 'A'; target <= 'Z'; target++) {
            int count = k;
            int start = 0;
            int i = 0;
            while (i < s.length()) {
                if (s.charAt(i) != target) {
                    if (count > 0) {
                        count--;
                    } else {
                        while (s.charAt(start) == target) {
                            start++;
                        }
                        start++;
                    }
                }
                if (max_Length < i - start + 1) max_Length = i - start + 1;
                i++;

            }
            i++;
        }
        return max_Length;
    }
}
