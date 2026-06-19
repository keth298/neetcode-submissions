class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character,Integer> sCounts = new HashMap<>();
        Map<Character,Integer> tCounts = new HashMap<>();
        if (s.length() != t.length()) return false;
        for(int i = 0; i < s.length(); i++){
            if(sCounts.containsKey(s.charAt(i))){
                sCounts.put(s.charAt(i),sCounts.get(s.charAt(i)) + 1);
            } else {
                sCounts.put(s.charAt(i), 1);
            }
            if(tCounts.containsKey(t.charAt(i))){
                tCounts.put(t.charAt(i),tCounts.get(t.charAt(i)) + 1);
            } else {
                tCounts.put(t.charAt(i), 1);
            } 
        }       
        for(Character c: sCounts.keySet()){
            if(!sCounts.get(c).equals(tCounts.get(c))){
                return false;
            }
        }
        return true;
    }
}
