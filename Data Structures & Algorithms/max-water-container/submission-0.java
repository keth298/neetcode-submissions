class Solution {
    public int maxArea(int[] heights) {
        int i = 0;
        int j = heights.length - 1;
        int max = Math.min(heights[i],heights[j]) * (j-i);
        while (i < j) {
            if (heights[i] > heights[j]) j--; else i++;
            int curr_max = Math.min(heights[i],heights[j]) * (j-i);
            if(curr_max > max) max = curr_max;
        }
        return max;
    }
}
