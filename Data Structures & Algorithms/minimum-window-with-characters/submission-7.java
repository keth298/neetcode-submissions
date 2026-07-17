class Solution {
    public String minWindow(String s, String t) {
        if(t.length() > s.length()) return "";

        Map<Character, Integer> tCount = new HashMap<>();
        for(int i = 0; i < t.length(); i++) tCount.put(t.charAt(i), tCount.getOrDefault(t.charAt(i), 0) + 1);
        
        Map<Character,Integer> curr = new HashMap<>();
        int have = 0;
        int need = tCount.size();

        int l = 0;
        int minLength = Integer.MAX_VALUE;
        int bestStart = 0;
        for(int r = 0; r < s.length(); r++){
            Character c = s.charAt(r);
            if(tCount.containsKey(c)){
                curr.put(c, curr.getOrDefault(c, 0) + 1);
                if(curr.get(c).equals(tCount.get(c))) have++;
            }
            while(have == need){
                if(r - l + 1 < minLength){
                    minLength = r - l + 1;
                    bestStart = l;
                }
                if(tCount.containsKey(s.charAt(l))){
                    curr.put(s.charAt(l), curr.get(s.charAt(l)) - 1);
                    if(curr.get(s.charAt(l)) < tCount.get(s.charAt(l))) have--;
                } 
                l++;
            }
        }
        return minLength == Integer.MAX_VALUE ? "" : s.substring(bestStart, bestStart + minLength);
    }
}
