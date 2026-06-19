class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> cur = new HashMap<>();
        int max_Length = 0;
        int start = 0;
        for(int i = 0; i < s.length(); i++){
            if(cur.containsKey(s.charAt(i))){
                start = Math.max(start, cur.get(s.charAt(i)) + 1);
            }
            cur.put(s.charAt(i), i);
            if(i - start + 1 > max_Length) max_Length = i - start + 1;
        }
        return max_Length;
    }
}
