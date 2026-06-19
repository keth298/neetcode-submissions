class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencies = new HashMap<>();

        for(Integer num: nums){
            if(frequencies.containsKey(num)){
                frequencies.put(num, frequencies.get(num) + 1);
            } else {
                frequencies.put(num, 1);
            }
        }

        List<Integer> keysList = new ArrayList<>(frequencies.keySet());
        keysList.sort((a, b) -> frequencies.get(b) - frequencies.get(a));

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = keysList.get(i);
        }
        return result;
    }
}
