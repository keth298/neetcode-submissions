class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] outputs = new int[nums.length];
        int prod = 1;
        int zeroes = 0;
        for(int num: nums){
            if(num != 0){
                prod *= num;
            } else {
                zeroes += 1;
            }
        }
        if(zeroes > 1) prod = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                outputs[i] = zeroes == 0 ? prod / nums[i]: 0;
            } else {
                outputs[i] = prod;
            }
        }
        return outputs;
    }
}  
