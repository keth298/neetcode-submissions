class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Integer[] indices = new Integer[position.length];
        for (int i = 0; i < position.length; i++) indices[i] = i;
        Arrays.sort(indices, (a, b) -> Double.compare(position[b], position[a])); 
        
        Deque<Double> stack = new ArrayDeque<>();
        for(int i = 0; i < position.length; i++){
            int idx = indices[i];
            double time = (double)(target - position[idx]) / speed[idx];
            if(stack.isEmpty() || time > stack.peek()) {
                stack.push(time);
            }

        }
        return stack.size();
    }
}
