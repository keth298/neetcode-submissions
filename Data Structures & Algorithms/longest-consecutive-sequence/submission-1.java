class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> possibleStarts = new HashMap<>();
        Set<Integer> numsSet = new HashSet<>();
        for (int num : nums) {
            numsSet.add(num);
        }
        for(Integer num: nums){
            if(!numsSet.contains(num - 1)) possibleStarts.put(num, 1);
        }
        for(Integer num: possibleStarts.keySet()){
            int next = num + 1;
            while(numsSet.contains(next)){
                possibleStarts.put(num,possibleStarts.get(num) + 1);
                next++;
            }
        }
        int longest = 0;
        for(Integer num: possibleStarts.keySet()){
            if(possibleStarts.get(num) > longest) longest = possibleStarts.get(num);
        }
        return longest;
    }
}
