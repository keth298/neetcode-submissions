class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int[] frequency1 = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            frequency1[s1.charAt(i) - 'a'] += 1;
        }

        int[] frequency2 = new int[26];
        for(int i = 0; i < s1.length(); i++){
            frequency2[s2.charAt(i) - 'a'] += 1;
        }
        for(int r = s1.length(); r < s2.length();r++){
            if(Arrays.equals(frequency1, frequency2)) return true;
            frequency2[s2.charAt(r) - 'a'] += 1;
            frequency2[s2.charAt(r - s1.length()) - 'a'] -= 1;
        }
        if(Arrays.equals(frequency1, frequency2)) return true;
        return false;
    }
}
