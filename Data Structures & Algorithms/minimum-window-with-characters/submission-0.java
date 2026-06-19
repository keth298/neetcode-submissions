class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> counts = new HashMap<>();
        for (char c : t.toCharArray()) counts.put(c, counts.getOrDefault(c, 0) + 1);
        Map<Character, Integer> window = new HashMap<>();
        int minLen = Integer.MAX_VALUE;
        String sub = "";
        int left = 0, count = 0;
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if (counts.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).intValue() <= counts.get(c).intValue()) count++;
            }
            while (count == t.length()) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    sub = s.substring(left, right + 1);
                }
                char leftChar = s.charAt(left);
                if (counts.containsKey(leftChar)) {
                    window.put(leftChar, window.get(leftChar) - 1);
                    if (window.get(leftChar) < counts.get(leftChar)) count--;
                }
                left++;
            }
        }
        return sub;
    }
}