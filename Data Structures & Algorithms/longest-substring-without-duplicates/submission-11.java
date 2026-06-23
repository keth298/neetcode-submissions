class Solution {
    public int lengthOfLongestSubstring(String s) {
        int start = 0;
        Set<Character> substring = new HashSet<>();
        int maxLength = 0;
        for(int i = 0; i < s.length(); i++){
            if(!substring.contains(s.charAt(i))){
                substring.add(s.charAt(i));
            } else {
                while(s.charAt(start) != s.charAt(i)){
                    substring.remove(s.charAt(start));
                    start++;
                }
                start++;
            }
            if(maxLength < i - start + 1) maxLength = i - start + 1;

        }
        return maxLength;
    }
}
