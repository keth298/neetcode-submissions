class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int num: nums){
            if(pq.size() == k){
                pq.add(num);
                pq.remove();
            } else {
                pq.add(num);
            }
        }

        return pq.peek();

    }
}
