class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
        for(int num: stones) max.add(num);

        while(max.size() > 1){
            int x = max.remove();
            int y = max.remove();
            if(x != y) max.add(Math.abs(x- y));
        }
        return max.isEmpty()? 0: max.peek();
    }
}
