class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int l = 0;
        int r = matrix.length * matrix[0].length;
        int[] m = new int[2];
        while(l < r){
            m[0] = ((r + l) / 2) / matrix[0].length;
            m[1] = ((r + l) / 2) % matrix[0].length;
            if (matrix[m[0]][m[1]] == target){
                return true;
            } else if(matrix[m[0]][m[1]] >= target){
                r = m[0] * matrix[0].length + m[1];
            } else {
                l = m[0] * matrix[0].length + m[1] + 1;
            }
            System.out.println(Arrays.toString(m));
            System.out.println(l);
            System.out.println(r);
        }
        if(matrix[m[0]][m[1]] == target) return true;
        else return false;
    }
}
