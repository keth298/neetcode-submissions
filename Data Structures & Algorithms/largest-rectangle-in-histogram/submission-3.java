class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] leftBounds = new int[n];
        int[] rightBounds = new int[n];
        
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = 0; i < n; i++){
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]) stack.pop();
            leftBounds[i] = stack.isEmpty() ? 0 : stack.peek() + 1;
            stack.push(i);
        }

        stack.clear();
        for(int i = n - 1; i >= 0; i--){
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]) stack.pop();
            rightBounds[i] = stack.isEmpty() ? n - 1 : stack.peek() - 1;
            stack.push(i);
        }


        int max = 0;
        for(int i = 0; i < n; i++){
            int area = heights[i] * (rightBounds[i] - leftBounds[i] + 1);
            if(area > max) max = area;
        }
        return max;
    }
}
