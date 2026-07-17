class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> potentials = new HashSet<>();
        Set<Integer> set = new HashSet<>();
        for(int num: nums) set.add(num);
        for(int num: set) if(!set.contains(num - 1)) potentials.add(num);
        int currNum = 0;
        int currLength = 0;
        int maxLength = 0;
        for(int num: potentials){
            currNum = num;
            currLength = 0;
            while(set.contains(currNum)){
                currNum++;
                currLength++;
            }
            if(maxLength < currLength) maxLength = currLength;
        }
        return maxLength;
    }
}
