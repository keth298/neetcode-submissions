class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        
        Deque<Double> stack = new ArrayDeque<>();
        Integer[] indices = new Integer[n];
        for(int i = 0; i < n; i++){
            indices[i] = i;
        }
        Arrays.sort(indices, (a, b) -> Integer.compare(position[b], position[a]));

        for(int i = 0; i < n; i++){
            int idx = indices[i];
            double time = (double) (target - position[idx]) / speed[idx];
            if(stack.isEmpty() || time > stack.peek()){
                stack.push(time);
            }
        }
        return stack.size();
    }
}