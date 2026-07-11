class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> frequencies = new HashMap<>();
        for(String s: strs){
            int[] letters = new int[26];
            for(int i = 0; i < s.length() ; i++){
                letters[s.charAt(i) - 'a']++;
            }
            String key = Arrays.toString(letters);
            if(frequencies.containsKey(key)){
                frequencies.get(key).add(s);
            } else {
                frequencies.put(key, new ArrayList<>(List.of(s)));
            }

        }
        List<List<String>> res = new ArrayList<>();
        for(String frequency: frequencies.keySet()){
            res.add(frequencies.get(frequency));
        }
        return res;
    }
}

