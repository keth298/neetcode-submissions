class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for(String s: strs){
            int[] letters = new int[26];
            for(int i = 0; i < s.length();i++){
                letters[s.charAt(i) - 'a'] += 1;
            }
            String key = Arrays.toString(letters);
            if (map.containsKey(key)) {
                map.get(key).add(s);
            } else {
                List<String> strings = new ArrayList<>();
                strings.add(s);
                map.put(key, strings);
            }
        }
        return new ArrayList<>(map.values());
    }
}
