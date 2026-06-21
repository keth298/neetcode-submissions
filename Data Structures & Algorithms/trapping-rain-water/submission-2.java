class Solution {
    public int trap(int[] height) {
        int water = 0;
        int i = 0;
        int j = height.length - 1;

        int left = 0;
        int right = 0;

        while(i <= j){
            if(left <= right){
                if(height[i] < left){
                    water += left - height[i];
                } else {
                    left = height[i];
                }
                i++;
            } else {
                if(height[j] < right){
                    water += right - height[j];
                } else {
                    right = height[j];
                }
                j--;
            }
        }
        return water;
    }
}

