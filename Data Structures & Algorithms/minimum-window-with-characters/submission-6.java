class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> freqT = new HashMap<>();
        for(int j = 0; j < t.length(); j++){
            freqT.put(t.charAt(j),freqT.getOrDefault(t.charAt(j), 0) + 1);
        }

        int start = 0;
        int best_start = 0;
        int best_end = Integer.MAX_VALUE;

        Map<Character, Integer> curr = new HashMap<>();
        for(int end = 0; end < s.length(); end++){
            if(freqT.containsKey(s.charAt(end))){
                curr.put(s.charAt(end),curr.getOrDefault(s.charAt(end), 0) + 1);
            }

            while(true){
                Boolean greater = true;
                for(Character c : freqT.keySet()){
                    if(curr.getOrDefault(c, 0) < freqT.get(c)) greater = false;
                }
                
                if(!greater) break;

                if(end - start < best_end - best_start){
                    best_start = start;
                    best_end = end;
                }
                if(freqT.containsKey(s.charAt(start))){
                    curr.put(s.charAt(start),curr.getOrDefault(s.charAt(start), 0) - 1);
                }
                start++;
            }
        }
        if(best_end == Integer.MAX_VALUE) return "";
        else return s.substring(best_start, best_end + 1);

    }
}