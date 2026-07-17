class KthLargest {
    PriorityQueue<Integer> kLargest;
    int max;
    public KthLargest(int k, int[] nums) {
        kLargest = new PriorityQueue<>();
        for(int num: nums){
            if(kLargest.size() == k){
                kLargest.add(num);
                kLargest.remove();
            } else {
                kLargest.add(num);
            }
        }
        max = k;
    }
    
    public int add(int val) {
        if(kLargest.size() == max){
            kLargest.add(val);
            kLargest.remove();
        } else {
            kLargest.add(val);
        }
        return kLargest.peek();
    }
}
